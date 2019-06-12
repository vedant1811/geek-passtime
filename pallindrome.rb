# longest pallindrome in a String

def longest_pallindrome(string)

  longest_length = 0

  (0..(string.size)).each do |start|
    (start..(string.size)).each do |last|
      substring = string[start..last]
      l = substring.size
      longest_length = l if pallindrome?(substring) && l > longest_length
    end
  end

  longest_length
end

def pallindrome?(string)
  mid = string.size/2

  (0..mid).each do |i|
    # puts "#{i} = #{string[i]} : #{string[-(i+1)]}"
    return false unless string[i] == string[-(i+1)]
  end
  true
end

puts longest_pallindrome("woow")
puts longest_pallindrome("abcd")
puts longest_pallindrome("wooow dd")
puts longest_pallindrome("abcd")
puts longest_pallindrome("abcd")
