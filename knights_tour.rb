# http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/

MOVEMENTS = [
  [2,1], [2,-1], [1,2], [1,-2],
  [-2,-1], [-2,-], [-1,-2], [-1,2],
]

# +path+ so far
def find_path(path)
  # try to move
  MOVEMENTS.each do |movement|
    current_pos = path.last
    next_pos = [current_pos[0] + movement[0], current_pos[1] + movement[1]]

    if (0...@n).include?(next_pos[0]) && (0...@n).include?(next_pos[1]) && !path.include?(next_pos)
      # a valid position and not yet visited

      path << next_pos
      if path.length == @n * @n # success
        return path
      else
        find_path path # continue finding
      end
    end # else just try the next position
  end
end

def main(n)
  @n = n
  find_path [[0,0]]
end
