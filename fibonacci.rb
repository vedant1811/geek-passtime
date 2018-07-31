@cache = []

def f(n)
  return 0 if n == 0
  return 1 if n == 1

  return @cache[n] if @cache[n]

  ans = f(n - 1) + f(n - 2)
  @cache[n] = ans
  ans
end

puts f(8181)
