# https://www.geeksforgeeks.org/water-jug-problem-using-bfs/

require 'set.rb'

Node = Struct.new(:x, :y) do
  attr_accessor :prev

  def path
    path = "(#{x},#{y})"
    if prev
      path = "#{prev.path} -> #{path}"
    end

    path
  end
end

class Graph
  def initialize(m, n)
    @m = m
    @n = n
  end

  def start
    Node.new 0, 0
  end

  def adjacents_of(node)
    x = node.x
    y = node.y

    adjacents = [
      Node.new(0, y),
      Node.new(x, 0),
      Node.new(@m, y),
      Node.new(x, @n)
    ]

    # x -> y
    adjacents << if x + y <= @n
      Node.new(0, x + y)
    else
      d = @n - y
      Node.new(x - d, @n)
    end

    # x <- y
    adjacents << if x + y <= @m
      Node.new(x + y, 0)
    else
      d = @m - x
      Node.new(@m, y - d)
    end

    adjacents.uniq.each { |e| e.prev = node }
  end
end

# d < m < n
def get_path(d, m, n)
  g = Graph.new(m, n)

  root = g.start

  visited = Set.new
  queue = [root]

  while !queue.empty?
    node = queue.shift

    if [node.x, node.y].include? d
      return node.path
    else
      visited << node
      g.adjacents_of(node).each do |adj|
        next if visited.include?(adj)

        queue << adj
      end
    end
  end

  'not possible'
end

puts get_path(2, 3, 4)
