require './trees'

# @return [max burnt length so far, longest distance from (burnt if found, else leaf) ]
def path_lengths(root)
  return [nil, 0] unless root

  return [1, 1] if root == @start

  left = path_lengths(root.left)
  right = path_lengths(root.right)

  if left.first
    [
      left.last + right.last + 1,
      left.first + 1
    ]
  elsif right.first
    [
      left.last + right.last + 1,
      right.first + 1
    ]
  else
    [
      nil,
      [left.last, right.last].max + 1
    ]
  end
end

def time_to_burn(root, start)
  @start = start
  path_lengths(root).first
end

tree = sample_tree

puts "#{time_to_burn(tree, tree.right.left)}"
puts "#{time_to_burn(tree, tree)}"
puts "#{time_to_burn(tree, tree.left)}"
