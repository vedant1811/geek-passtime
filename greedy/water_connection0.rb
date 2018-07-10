# https://www.geeksforgeeks.org/water-connection-problem/

# too complicated to debug
def water_connection(input)
  tanks = {}
  taps = {}

  input.each do |line|
    tank = line.first
    tap = line[1]
    pipe = line.last
    if tanks.key?(tap) && taps.key?(tank)
      value1 = tanks.delete(tap)
      value2 = taps.delete(tank)
      value = [value1[1], value2.first, [value1.last, value2.last, pipe].min]

      taps[value[1]] = value
      tanks[value.first] = value
    elsif tanks.key?(tap)
      value = tanks.delete(tap)
      value.first = tank
      value[2] = [value.last, pipe].min

      taps[value[1]] = value
      tanks[value.first] = value
    elsif taps.key?(tank)
      value = taps.delete(tank)
      value[1] = tap
      value[2] = [value.last, pipe].min

      taps[value[1]] = value
      tanks[value.first] = value
    else
      value = [tank, tap, pipe]
      tanks[tank] = value
      taps[tap] = value
    end
  end

  tanks.values
end

input = [ [ 7, 4, 98 ],
  [ 5, 9, 72 ],
  [ 4, 6, 10 ],
  [ 2, 8, 22 ],
  [ 9, 7, 17 ],
  [ 3, 1, 66 ] ]

ans = water_connection(input)
ans.each { |e| puts e.join(' ') }
