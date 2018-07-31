require './trees.rb'

def traverse(root)
  linked_list = []
  linked_list << root
  linked_list << :break

  while linked_list.size > 0
    element = linked_list.shift
    if element == :break
      puts
      linked_list << :break unless linked_list.size == 0
    else
      linked_list << element.left if element.left
      linked_list << element.right if element.right

      print "(#{element.data})"
      print ',' unless linked_list.first == :break
    end
  end
end

traverse sample_tree
