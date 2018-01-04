# https://leetcode.com/problems/palindromic-substrings/description/

class String
  def pallindrome?
    self == self.reverse ? 1 : 0
  end
end

# @param {String} s
# @return {Integer}
def count_substrings(s)
  @string = s
  count = 0
  (1..s.length).each do |l|
    count += count_pallindromes_of_length(l)
  end
  count
end

def count_pallindromes_of_length(l)
  return @string.length if l == 1
  count = 0
  last_index = @string.length - l
  (0..last_index).each do |i|
    count += 1 if @string[i, l].pallindrome?
  end
  count
end
