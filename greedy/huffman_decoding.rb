# https://www.geeksforgeeks.org/huffman-decoding/

require './huffman_coding.rb'

def huffman_decode(root, input)
  @root = root
  @input = input

  traverse(@root, 0)
end

def traverse(node, i)
  return if i == @input.size

  # puts "node: #{node.code}, c: #{@input[i]}, i: #{i}"

  if @input[i] == '0'
    next_node = node.left
  else
    next_node = node.right
  end

  if next_node.char
    puts next_node.char
    next_node = @root
  end

  traverse(next_node, i + 1)
end

root = create_tree(['a', 'b', 'c', 'd', 'e', 'f'], [5, 9, 12, 13, 16, 45])
huffman_decode(root, '0110011011001011110') # fabcdef
