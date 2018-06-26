# https://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-problem/

def max_activities(start, finish)
  n = start.count
  last = 0
  count = 0
  (0...n).each do |i|
    if last <= start[i]
      count += 1
      last = finish[i]
    end
  end
  count
end

puts max_activities([1, 3, 0, 5, 8, 5], [2, 4, 6, 7, 9, 9])
puts max_activities([10, 12, 20], [20, 25, 30])
