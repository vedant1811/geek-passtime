# http://www.geeksforgeeks.org/knapsack-problem/

def max_value(remaing_weight, i)
  if i == @length
    return 0
  end

  cache_params = [remaing_weight, i]
  cache_value = @cache[cache_params]
  if cache_value
    puts "cache hit for #{cache_params} => #{cache_value}"
    return cache_value
  end

  values = [max_value(remaing_weight, i + 1)]
  values << @values[i] + max_value(remaing_weight - @weights[i], i + 1) if remaing_weight >= @weights[i]
  max_value = values.max

  @cache[cache_params] = max_value
  max_value
end

def main(weights, values, max_weight)
  @weights = weights
  @values = values
  @max_weight = max_weight
  @length = weights.length
  @cache = {} # [remaing_weight, i] => max_value

  value = max_value max_weight, 0
  puts "max value: #{value}"
end
