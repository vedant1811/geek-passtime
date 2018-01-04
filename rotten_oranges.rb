# http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/



def oranges(crate)
  @m = crate[0].length
  @n = crate.length
  @max_int = @m * @n
  @crate = crate
  @t = Array.new(@n) { Array.new @m }
  @max_t = 0
  (0...@n).each do |i|
    (0...@m).each do |j|
      return -1 if min_t(i, j) == -1
    end
  end
  @max_t
end

crate = [[1, 1, 1, 2, 1],
         [1, 0, 1, 2, 1],
         [1, 0, 0, 2, 1]]

puts "oranges will rot in #{oranges(crate)}"
