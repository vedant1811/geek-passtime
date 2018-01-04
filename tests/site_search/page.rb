require './keywordable'

class Page
  include Keywordable

  attr_reader :children

  # @param Array of keywords. Example: ["Ford", "Car", "Review"]
  def initialize(words)
    create_keywords words
    @children = []
  end

  def strength_rating_with(query)
    strength = 0
    common_keys = keywords.keys & query.keywords.keys # perform a set intersection of the 2 keys
    common_keys.each do |key|
      strength += query.keywords[key] * keywords[key]
    end
    @children.each do |child|
      strength += child.strength_rating_with(query) * 0.1
    end
    strength
  end
end
