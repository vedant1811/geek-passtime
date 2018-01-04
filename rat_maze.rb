# http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/

def find_path(current_pos)
  return true if current_pos == [@length - 1, @length - 1]

  right = [current_pos[0], current_pos[1] + 1]
  down = [current_pos[0] + 1, current_pos[1]]

  [right, down].each do |next_pos|
    if can_traverse?(next_pos)
      @solution[next_pos[0], next_pos[1]] = 1
      find_path next_pos
    end
  end

  @solution[current_pos[0], current_pos[1]] = 0
  false
end

def main(maze)
  @maze = maze
  @side = @maze.length
  @solution = Array.new(@side) {Array.new(@side) {0}} # 2D array initialized to zero
  find_path [0,0]
end

def can_traverse?(position)
  i = position[0]
  j = position[1]
  (0...@length).include?(i) && (0...@length).include?(j) && @maze[i][j] == 1
end
