class Lift
  FLOORS = 10.freeze

  def initialize
    @floors = []
    (0..FLOORS).each do |i|
      @floors << Floor.new
    end
    @current_floor = 0 # ground floor
    @up = true # lift is either going up, or going down
  end

  def move
    if @up
      if @current_floor == FLOORS # top floor
        @up = false
        move
        return
      else
        @current_floor += 1
      end
    else
      if current_floor == 0
        @up = true
        move
        return
      else
        @current_floor -= 1
      end
    end
    if @floors[@current_floor].stop_here?
      puts "stopped at #{current_floor}"
    else
      puts "moving to #{current_floor}"
      move
    end
  end

  # call the lift from outside
  def call(floor, direction_sym)
    if direction_sym == :up
      @floors[floor].up_pressed = true
    else
      @floors[floor].down_pressed = true
    end
  end

  # press a floor button inside the lift
  def goto_floor(floor)
    @floors[floor].button_pressed = true
  end
end
