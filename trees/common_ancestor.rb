# http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/

# returns +int+
def traverse(node)
  return 0 unless node.data
  count = node.data.in?([n1, n2]) ? 1 : 0
  count += traverse node.left
  return if count > 2 # common ancestor has already been printed
  if count == 2 # count just became 2
    puts "common ancestor.data = #{node.data}"
    return 7
  end
  count += traverse node.right
  return if count > 2 # common ancestor has already been printed
  if count == 2 # count just became 2
    puts "common ancestor.data = #{node.data}"
    return 7
  end
  return count
end
