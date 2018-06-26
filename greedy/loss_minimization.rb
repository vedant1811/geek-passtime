# https://www.geeksforgeeks.org/job-sequencing-problem-loss-minimization/

def loss_minimization(l, t)
  pairs = []
  (0...l.count).each do |i|
    pairs << [t[i], l[i], i]
  end

  pairs.sort! { |a, b| a.first == b.first ? b[1] <=> a[1] : a.first <=> b.first }

  last = nil
  ans = []
  pairs.each do |pair|
    unless last
      last = pair
      next
    end

    if last[1] * pair.first >= pair[1] * last.first
      ans << last.last
      last = pair
    else
      ans << pair.last
    end
  end
  ans << last.last
  ans.map { |e| e + 1 }
end

l = [1, 2, 3, 5, 6]
t = [2, 4, 1, 3, 2]

puts loss_minimization(l, t)

l = [3, 1, 2, 4]
t = [4, 1000, 2, 5]

puts loss_minimization(l, t)
