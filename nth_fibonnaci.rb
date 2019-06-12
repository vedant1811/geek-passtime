# https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

MATRIX_1 = [
  [1, 1],
  [1, 0],
]

@exp_cache = {}

def nth_fibonacci(n)
  return n if n <= 1

  exponent(n - 1)[0][0]
end

# MATRIX_1 ^ power
def exponent(power)
  return @exp_cache[power] if @exp_cache[power]

  # puts "exp #{power}"

  ans = if power == 1
    MATRIX_1
  elsif power % 2 == 0
    m2 = exponent(power/2)
    multiply(m2, m2)
  else
    m1 = exponent(power/2)
    m2 = exponent(power/2 + 1)
    multiply(m1, m2)
  end

  @exp_cache[power] = ans
end

# m1 x m2
def multiply(m1, m2)
  # puts "#{m1} mul #{m2}"
  [
    [m1[0][0] * m2[0][0] + m1[0][1] * m2[1][0], m1[0][0] * m2[0][1] + m1[0][1] * m2[1][1]],
    [m1[1][0] * m2[0][0] + m1[1][1] * m2[1][0], m1[1][0] * m2[0][1] + m1[1][1] * m2[1][1]],
  ]
end


puts nth_fibonacci(0)
puts nth_fibonacci(1)
puts nth_fibonacci(2)
puts nth_fibonacci(9)
puts nth_fibonacci(16)
