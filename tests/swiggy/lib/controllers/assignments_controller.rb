require 'json'

class AssignmentsController

  def create
    @orders = Order.all
    @des = DeliveryExecutive.all

    create_assignments
    {assignments: @assignments}.to_json
  end

  def create_assignments
    @assignments = []
    @orders.each do |o|
      h = {order: o, delivery_executive: @des[0]}
      current_a = Assignment.new(h)
      @des.each do |de|
        possible_a = Assignment.new({order: o, delivery_executive: de})
        puts possible_a
        if (possible_a <=> current_a) < 0
          current_a = possible_a
        end
      end
      current_a.dispatch! # entension
      @assignments << {order_id: current_a.order.id, de_id: current_a.delivery_executive.id}
    end
  end
end
