##
# enables including classes to have keywords mapped to weights
# stores keywords downcased to facilitate case-insensitive matching
module Keywordable
  attr_reader :keywords

  # create the keywords Hash.
  # NOTE: if keywords are repeated, the higher weight is assigned
  # @param Array of keywords. Example: ["Ford", "Car", "Review"]
  def create_keywords(words)
    @keywords = {}
    weight = MAX_WEIGHT
    words.each do |word|
      key = word.downcase
      @keywords[key] = weight unless @keywords[key] # set the weight only if it is not set
      weight -= 1

      # no point in storing 0 weight keywords or storing negetive weights
      break if weight == 0
    end
  end
end
