require './page'
require './query'

MAX_WEIGHT = 8.freeze
MAX_RESULTS = 5.freeze

# @param {String} string: A multiline string that is the input for the problem
# Example: "P Ford Car Review\nP Review Car\nP Review Ford\nP Toyota Car\nP Honda Car\nP Car\nQ Ford\nQ Car\nQ Review\nQ Ford Review\nQ Ford Car\nQ cooking French\n"
def main(input)
  # Use an instance variable since it is consistent accross all queries, and let it be used by other functions
  @pages = []

  queries = []
  # Parse all the pages and queries
  lines = input.split("\n")
  lines.each do |line|
    words = line.split(' ')
    # remove the first element in the array and check if its 'P' or 'Q'
    case words.shift
    when 'P'
      @pages << Page.new(words)
    when 'Q'
      queries << Query.new(words)
    when 'PP'
      @pages.last.children << Page.new(words)
    when 'PPP'
      @pages.last.children.last.children << Page.new(words)
    else
      raise "Unknown code letter"
    end
  end

  queries.each_with_index do |query, i|
    top_pages = run_query query
    puts "Q#{i + 1}: #{top_pages.join(' ')}"
  end
  0 # no error
end

# Takes a +Query+ object and
def run_query(query)
  # mapping of rating to array of strings (like 'P1', 'P8', etc.). An array is used since duplicate ratings are possible.
  # Example:
  # {
  #   56: ['P3', 'P8'],
  #   102: ['P1'],
  #   32: ['P7']
  # }
  results = {}

  # iterate over each page and store its rating in +results+
  @pages.each_with_index do |page, i|
    strength = page.strength_rating_with query
    if strength > 0 # exclude no match
      results[strength] = [] unless results[strength] # initialize to array if needed
      results[strength] << "P#{i + 1}"
    end
  end

  top_pages = []
  # take the ratings (i.e. keys), sort them, then reverse iterate through them
  results.keys.sort.reverse_each do |key|
    top_pages += results[key]
    break if top_pages.length >= MAX_RESULTS
  end

  # return only 5 results. more than 5 are possible even with the above +break+ because the last matching key can have multiple pages
  top_pages[0, MAX_RESULTS]
end
