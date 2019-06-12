# https://leetcode.com/problems/median-of-two-sorted-arrays/

# nums1 is not larger than nums2
def median(nums1, nums2, p1 = nums1.count/2)
  count = nums1.count + nums2.count
  p2 = count/2 - p1

  # nums1 and nums2 are each divided into s1,l1 and s2,l2. s = smaller, l = larger
  s1max = p1 > 0 ? nums1.fetch(p1-1, -Float::INFINITY) : -Float::INFINITY
  s2max = p2 > 0 ? nums2.fetch(p2-1, -Float::INFINITY) : -Float::INFINITY
  l1min = nums1.fetch p1, Float::INFINITY
  l2min = nums2.fetch p2, Float::INFINITY

  puts "#{nums1[0...p1]} : #{nums1[p1...nums1.count]}"
  puts "#{nums2[0...p2]} : #{nums2[p2...nums2.count]}"
  # puts "#{[s1max, s2max, l1min, l2min]}"
  puts

  if s1max <= l2min && s2max <= l1min
    if count % 2 == 0
      return ([s1max, s2max].max + [l1min, l2min].min)/2.0
    else
      return [l1min, l2min].min
    end
  elsif s1max > l2min
    p1 = p1/2
  else
    p1 = (nums1.count+p1+1)/2
  end

  median nums1, nums2, p1
end

# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)
  nums1, nums2 = nums2, nums1 if nums1.count > nums2.count
  median nums1, nums2
end

# puts "#{find_median_sorted_arrays [1,3], [2]}"
# puts "#{find_median_sorted_arrays [1,2,3], [4,5,6]}"
# puts "#{find_median_sorted_arrays [1,2,3,7,8,9], [4,5,6]}"
# puts "#{find_median_sorted_arrays (1..10).to_a, (11..20).to_a}"
puts "#{find_median_sorted_arrays [1,2,3,6,7], [4,5,8,9,10]}"
