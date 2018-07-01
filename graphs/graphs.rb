require 'set.rb'

# A directed Graph's node
class GraphNode
  attr_reader :adjacents

  def initialize(value)
    @value = value
    @adjacents = Set.new
  end

  def <<(node)
    @adjacents << node
    self
  end
end

def sample_graph
  root = GraphNode.new(2)
  g0 = GraphNode.new(0)
  g1 = GraphNode.new(1)
  g3 = GraphNode.new(3)

  root << g3 << g0
  g3 << g3
  g0 << root << g1
  g1 << root

  root
end
