Dir["./lib/models/*.rb"].each { |file| require file }
Dir["./lib/controllers/*.rb"].each { |file| require file }

def test
  orders_json = %{
    [
      {
        "restaurant_location": "12.97,77.59",
        "ordered_time": "T1",
        "id": 123
      },
      {
        "restaurant_location": "12.97,77.59",
        "ordered_time": "T2",
        "id": 321
      }
    ]
  }

  des_json = %{
    [
      {
        "id": 567,
        "current_location": "12.975,77.595",
        "last_order_delivered_time": "T3"
      },
      {
        "id": 765,
        "current_location": "12.975,77.595",
        "last_order_delivered_time": "T4"
      },
      {
        "id": 766,
        "current_location": "12.90,77.50",
        "last_order_delivered_time": "T5"
      }
    ]
  }

  Order.bulk_create orders_json
  DeliveryExecutive.bulk_create des_json

  assignments_controller = AssignmentsController.new
  puts assignments_controller.create
end

test
