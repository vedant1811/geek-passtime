require 'json'

class BaseModel
  attr_accessor :id

  def initialize(hash)
    hash.each do |key, value|
      key = key.to_s
      value = Location.new(value) if key.end_with?('location')
      public_send key + '=', value
    end
  end

  def self.bulk_create(json_array)
    array = JSON.parse json_array
    @objects = []
    array.each do |e|
      @objects << new(e)
    end
  end

  def self.all
    @objects
  end
end
