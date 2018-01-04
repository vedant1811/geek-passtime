class Floor
  attr_accessible :up_pressed, :down_pressed, :button_pressed

  # def initialize(value)
  #   @value = value
  # end

  def stop_here?(direction_boolean)
    button_pressed || (direction_boolean ? up_pressed : down_pressed)
  end
end
