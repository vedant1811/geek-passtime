# https://www.geeksforgeeks.org/water-connection-problem/

require 'set.rb'

class Node
  attr_accessor :index, :pipe, :next_node

  def initialize(i)
    self.index = i
  end

  def get_ans(start = index, p = pipe)
    if next_node
      next_node.get_ans(start, [p, pipe].min)
    else
      [start, index, p]
    end
  end
end

def new_node(tank, tap, pipe)
  next_node = @nodes[tap] ||= Node.new(tap)
  cur_node = @nodes[tank] ||= Node.new(tank)

  cur_node.next_node = next_node
  cur_node.pipe = pipe

  @origins << cur_node
  @non_origins << next_node
end

def water_connection(input)
  @nodes = []
  @origins = Set.new
  @non_origins = Set.new

  input.each do |line|
    tank = line[0]
    tap = line[1]
    pipe = line[2]

    new_node(tank, tap, pipe)
  end

  @origins = @origins - @non_origins

  ans = []

  @origins.each do |node|
    ans << node.get_ans
  end

  ans
end

input = [ [ 7, 4, 98 ],
  [ 5, 9, 72 ],
  [ 4, 6, 10 ],
  [ 2, 8, 22 ],
  [ 9, 7, 17 ],
  [ 3, 1, 66 ] ]

ans = water_connection(input)
ans.each { |e| puts e.join(' - ') }
