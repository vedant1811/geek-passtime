# Coding in Ruby

# Read data from STDIN as a string
data = STDIN.read
n1, n2 = data.split(',').map(&:to_i)

# Write to stdout
puts n1 + n2
