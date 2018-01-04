require './lib/models/base_model'

class Order < BaseModel
  attr_accessor :ordered_time, :restaurant_location

end
