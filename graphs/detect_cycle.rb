# https://www.geeksforgeeks.org/?p=18516

require './graphs.rb'

@visited = Set.new

def has_cycle?(root)
  return true if @visited.include?(root)
  @visited << root

  root.adjacents.each do |node|
    return true if has_cycle?(node)
  end

  @visited.delete root

  false
end

puts has_cycle?(sample_graph)
