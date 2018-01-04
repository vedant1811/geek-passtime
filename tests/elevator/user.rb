class User
  def initialize(lift, current_floor = 0)
    @lift = lift
    @current_floor = current_floor
  end

  def goto_floor(floor)
    if floor == current_floor
      puts "Already on floor ##{floor}"
    else
      direction = floor > current_floor ? :up : :down
      @lift.call(current_floor, direction)
      puts "Pressed lift's #{direction.to_s} button on floor ##{current_floor}"
      
    end
  end
end
