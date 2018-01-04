require './lib/models/base_model'

class Assignment < BaseModel
  attr_accessor :order, :delivery_executive

  def distance
    order.restaurant_location.distance_from(delivery_executive.current_location).round(1)
  end

  def dispatch!
    # update time of the DeliveryExecutive
    delivery_executive.last_order_delivered_time.prepend "z"
  end

  # -1 means self is prioritized
  def <=>(other)
    if (distance != other.distance)
      return distance <=> other.distance
    end

    if delivery_executive.last_order_delivered_time > other.delivery_executive.last_order_delivered_time
      return 1
    elsif delivery_executive.last_order_delivered_time < other.delivery_executive.last_order_delivered_time
      return -1
    end

    if order.ordered_time > other.order.ordered_time
      return 1
    elsif order.ordered_time < other.order.ordered_time
      return -1
    end

    0 # equal
  end

  def to_s
    "distance,de_t,order_t #{order.id} -> #{delivery_executive.id} : #{distance}km,#{delivery_executive.last_order_delivered_time},#{order.ordered_time}"
  end
end
