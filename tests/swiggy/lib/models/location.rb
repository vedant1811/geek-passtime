require './lib/models/base_model'

class Location < BaseModel
  attr_accessor :latitude, :longitude

  def initialize(string)
    values = string.split ','
    @latitude = values[0].to_f
    @longitude = values[1].to_f
  end

  def distance_from(other)
    # Calculate radial arcs for latitude and longitude
    dLat = (latitude - other.latitude) * Math::PI / 180
    dLon = (longitude - other.longitude) * Math::PI / 180

    a = Math.sin(dLat / 2) *
        Math.sin(dLat / 2) +
        Math.cos(latitude * Math::PI / 180) *
        Math.cos(other.latitude * Math::PI / 180) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2)

    c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))

    6371 * c
  end
end
