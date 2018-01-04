# http://www.geeksforgeeks.org/convert-a-given-binary-tree-to-doubly-linked-list-set-4/

require './trees'

include Treeable

def main(tree_root)
  traverse tree_root

  print_linked_list @head
end

# perform in order traversal
def traverse(node)
  return unless node

  traverse node.left

  # instead of +print node.data+ perform the reference manipulations
  if @prev
    node.left = @prev
    @prev.right = node
  else
    @head = node
  end
  @prev = node

  traverse node.right
end

def print_linked_list(head)
  node = head
  print node.data
  while node.right
    print '->'
    node = node.right
    print node.data
  end
  puts ''
  print node.data
  while node.left
    print '->'
    node = node.left
    print node.data
  end
end
