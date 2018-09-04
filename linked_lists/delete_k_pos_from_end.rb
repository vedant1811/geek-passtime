# Given a singly linked linked list, delete the k-th element from end
class Node
  attr_reader :value
  attr_accessor :next

  def initialize(value)
    @value = value
  end

  def to_s
    "-> #{value} #{self&.next}"
  end

  def self.generate(size = 5)
    head = old = nil
    (0...size).each do |i|
      node = Node.new(i)
      old&.next = node

      head = node unless head

      old = node
    end
    head
  end
end


def delete_kth_from_end(head, k)
  cur = head
  kth = nil
  prev = nil
  while cur
    if k == 0
      kth = head
    else
      prev = kth
      kth = kth&.next
    end

    k -= 1
    cur = cur.next
  end

  if kth == head
    head = kth&.next
  elsif prev
    prev.next = kth.next
  end

  head
end

puts Node.generate.to_s

puts delete_kth_from_end(Node.generate, 3)
puts delete_kth_from_end(Node.generate, 0)
puts delete_kth_from_end(Node.generate, 4)
puts delete_kth_from_end(Node.generate, 5)
puts delete_kth_from_end(Node.generate, 6)
