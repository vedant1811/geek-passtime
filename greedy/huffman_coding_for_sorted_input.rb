# https://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding-set-2/

require './huffman_coding.rb'

def pop(q1, q2)
  if q1.empty?
    q2.shift
  elsif q2.empty?
    q1.shift
  elsif q1.first.code <= q2.first.code
    q1.shift
  else
    q2.shift
  end
end

def create_tree(chars, frequencies)
  q1 = Array.new
  (0...chars.count).each do |i|
    node = HuffmanNode.new(frequencies[i], chars[i])
    q1 << node
  end

  q2 = Array.new

  while q1.count + q2.count > 1
    smaller = pop(q1, q2)
    larger = pop(q1, q2)

    node = HuffmanNode.new(smaller.code + larger.code)
    node.left = smaller
    node.right = larger

    q2 << node
  end

  root = q2.pop

  print_codes root

  root
end

create_tree(['a', 'b', 'c', 'd', 'e', 'f'], [5, 9, 12, 13, 16, 45])
