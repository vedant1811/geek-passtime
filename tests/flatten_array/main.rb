def flatten_array(array)
  ans = []
  array&.each do |element|
    if element.is_a? Array
      ans += flatten_array(element)
    else
      ans << element
    end
  end
  ans
end
