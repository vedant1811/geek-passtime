class TreeNode
  attr_accessor :left, :right, :data

  def initialize(data)
    @data = data
  end
end

def sample_tree
  root = TreeNode.new 2
  root.left = TreeNode.new 1
  root.right = TreeNode.new 3
  root.left.left = TreeNode.new 0
  root.left.right = TreeNode.new 7
  root.right.left = TreeNode.new 9
  root.right.right = TreeNode.new 1

  root
end

module Treeable
  # an array of data
  def construct_heap(array)
    @array = array
    tree_root = create_heap_parent 0
    print "tree: "
    pre_order_traversal tree_root
    puts ''
    tree_root
  end

  def pre_order_traversal(node)
    return unless node
    print("#{node.data},")
    pre_order_traversal(node.left)
    pre_order_traversal(node.right)
  end

  private
    # Create parent and 2 children. +i+ is index of parent to create.
    def create_heap_parent(i)
      return nil if i >= @array.length || @array[i] == nil

      parent = TreeNode.new
      parent.data = @array[i]
      parent.left = create_heap_parent(2*i + 1)
      parent.right = create_heap_parent(2*i + 2)

      parent
    end
end
