# Imagine you are playing a board game. You roll a 6-faced dice and move forward
# the same number of spaces that you rolled. If the finishing point is “n” spaces
# away from the starting point, please implement a program that calculates how many
# possible ways there are to arrive exactly at the finishing point.

@cache = [0, 1]
def possible_ways(n)
  @cache[n] ||= begin
    ways = 0
    (1..[6,n - 1].min).each do |i|
      ways += possible_ways(n - i)
    end
    ways += 1 if n <= 6
    ways
  end
end

puts possible_ways 610
