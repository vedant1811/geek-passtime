# https://www.geeksforgeeks.org/longest-subarray-such-that-the-difference-of-max-and-min-is-at-most-one/

def length_of_subarray(array)
  left = 0
  max = [array&.size || 0, 1].min

  nums = nil
  next_left = 0
  right = 0

  (1...array.size).each do |i|
    cur = array[i]
    if nums
      if nums.size == 1 && cur != nums[0] && (nums[0] - cur).abs <= 1
        nums << cur
      end

      if nums.include?(cur)
        next_left = i if array[next_left] != cur
      else
        size = right - left + 1
        max = size if size > max

        left = next_left
        nums = nil
      end
    end

    right = i

    if !nums
      next_left = i
      if (array[left] - cur).abs <= 1
        nums = [array[left], cur].uniq
      else
        left = i
      end
    end

  end
  [max, right - left + 1].max
end

puts length_of_subarray([3, 3, 4, 4, 5, 6])
puts length_of_subarray([7, 7, 7])
puts length_of_subarray([9, 8, 8, 9, 9, 10])
puts length_of_subarray([7, 7, 7, 8])
