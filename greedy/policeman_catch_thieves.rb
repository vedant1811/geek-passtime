# https://www.geeksforgeeks.org/policemen-catch-thieves/

def catch(arr, k)
  ps = 0
  ts = 0
  count = 0

  arr.each do |e|
    if e == 'T'
      if ps > 0
        ps -= 1
        count += 1
      else
        ts += 1 unless ts >= k
      end
    else
      if ts > 0
        ts -= 1
        count += 1
      else
        ps += 1 unless ps >= k
      end
    end
  end

  count
end

puts catch(['P', 'T', 'P', 'T', 'T', 'P'], 1)
