# https://leetcode.com/problems/queue-reconstruction-by-height/description/

def reconstruct(heights)
  heights.sort! do |a, b|
    if a.first == b.first
      a.last <=> b.last
    else
      b.first <=> a.first
    end
  end

  ans = []

  heights.each do |e|
    ans.insert e.last, e.join(',')
  end

  ans
end


input = [[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]

ans = reconstruct input
puts ans.join('  ')
