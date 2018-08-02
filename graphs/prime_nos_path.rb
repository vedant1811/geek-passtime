# https://www.geeksforgeeks.org/shortest-path-reach-one-prime-changing-single-digit-time/

require 'prime.rb'
require 'set.rb'

def primes
  Prime.each(9999).select { |e| e > 999 }
end

Node = Struct.new(:n) do
  attr_accessor :depth

  def adjacents
    primes.select do |p|
      n_string = n.to_s
      p_string = p.to_s
      count = 0
      (0...4).each do |i|
        count += 1 if n_string[i] == p_string[i]
      end
      puts "#{n} x #{p} = #{count}"
      count == 3
    end
    .map do |p|
      node = Node.new p
      node.depth = (depth || 0) + 1
      node
    end
  end
end

def shortest_path(x, y)
  visited = Set.new
  queue = [ Node.new(x) ]
  while !queue.empty?
    node = queue.shift
    puts node.n
    return node.depth if node.n == y

    visited << node
    node.adjacents.each do |adj|
      queue << adj unless visited.include? adj
    end
  end
  'not possible'
end

puts shortest_path 1033, 8179
