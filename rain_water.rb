LENGTH = 10.freeze
MAX_INDEX = 9.freeze

def generate_random
  input = Array.new(LENGTH) { rand(MAX_INDEX + 1) } # numbers 0 to 9
  main input
end

# input like [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
# Output: 6
#        |
#    |   || |
# _|_||_||||||
def main(array)
  # print the input
  puts "input: #{array}"
  height = array.max
  (height.downto(1)).each do |y|
    array.each do |x|
      if x >= y
        print '|'
      elsif x == 0 && y == 1
        print '_'
      else
        print ' '
      end
    end
    puts ''
  end

  @array = array
  water = 0
  left = 0
  right = @array.length - 1
  left_max = @array[left]
  right_max = @array[right]
  left_potential = 0
  right_potential = 0
  while left < right
    if @array[left] < @array[right]
      left += 1
      if left_max < @array[left] # hit a higher wall
        left_max = @array[left]
        water += left_potential
        left_potential = 0
      else
        left_potential += left_max - @array[left]
      end
    else
      right -= 1
      if right_max < @array[right] # hit a higher wall
        right_max = @array[right]
        water += right_potential
        right_potential = 0
      else
        right_potential += right_max - @array[right]
      end
    end
    # puts "%02d %02d %02d %02d %02d %02d =%02d" % [left, left_max, left_potential, right, right_max, right_potential, water]
  end
  water += left_potential + right_potential
  water
end
