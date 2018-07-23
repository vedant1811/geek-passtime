def balance(string)
  offset = 0
  swaps = 0
  string.each_char do |c|
    if c == '['
      if offset > 0
        swaps += offset
      end
      offset -= 1
    else
      offset += 1
    end
  end

  swaps
end

puts balance("[]][][")
puts balance("[[][]]")
puts balance("]]][[[")
