# https://www.geeksforgeeks.org/greedy-algorithms-set-3-huffman-coding/

class HuffmanNode
  attr_accessor :char, :code, :left, :right

  def initialize(code, char = nil)
    self.code = code
    self.char = char
  end

  def <=>(other)
    code <=> other.code
  end

  def to_str
    code.to_s
  end
end

class MinHeap
  def initialize
    @array = []
  end

  def <<(item)
    @array << item
    @array.sort!
    self
  end

  def pop
    @array.delete_at 0
  end

  def count
    @array.count
  end
end

def print_codes(root, prefix = '')
  return unless root

  if root.char
    puts "#{root.char}: #{prefix}"
  end

  print_codes root.left, prefix + '0'
  print_codes root.right, prefix + '1'
end

def create_tree(chars, frequencies)
  heap = MinHeap.new
  (0...chars.count).each do |i|
    node = HuffmanNode.new(frequencies[i], chars[i])
    heap << node
  end

  while heap.count > 1
    smaller = heap.pop
    larger = heap.pop

    node = HuffmanNode.new(smaller.code + larger.code)
    node.left = smaller
    node.right = larger

    heap << node
  end

  root = heap.pop

  print_codes root

  root
end

# create_tree(['a', 'b', 'c', 'd', 'e', 'f'], [5, 9, 12, 13, 16, 45])
