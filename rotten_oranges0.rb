# http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
# wrong method

def min_t(i, j)
  return @max_int if i < 0 || j < 0 || i >= @n || j >= @m
  return @t[i][j] if @t[i][j]

  case @crate[i][j]
  when 0
    t = @max_int
  when 2
    t = 0
  when 1
    @t[i][j] = @max_int - 1
    puts "#{i},#{j}==> #{@t[i][j]}"
    next_t = [min_t(i+1, j), min_t(i, j+1), min_t(i-1, j), min_t(i, j-1)].min
    if next_t == @max_int
      return -1
    end
    t = 1 + next_t
    @max_t = t if t > @max_t
  end
  puts "#{i},#{j}: #{t}"
  @t[i][j] = t
  return t
end

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
