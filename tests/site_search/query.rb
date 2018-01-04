require './keywordable'

class Query
  include Keywordable

  # @param Array of keywords. Example: ["Car", "Review"]
  def initialize(words)
    create_keywords words
  end
end
