require './lift'
require './user'

def setup
  @lift = Lift.new
  @users = [
    User.new(@lift),
    User.new(@lift, 5),
    User.new(@lift, 3),
  ]
end

setup

# public methods:
def move_lift
  @lift.move
end
