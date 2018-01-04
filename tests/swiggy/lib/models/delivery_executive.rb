require './lib/models/base_model'

class DeliveryExecutive < BaseModel
  attr_accessor :current_location, :last_order_delivered_time

end
