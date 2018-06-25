def egyptian_fraction(nr, dr)
  return if [nr, dr].include? 0

  if nr >= dr
    print "#{nr/dr}/1, "
    return egyptian_fraction(nr % dr, dr)
  end

  cur_dr = (dr.to_f / nr).ceil
  print "1/#{cur_dr}, "

  return if dr % nr == 0 # numerator is 1

  egyptian_fraction(nr * cur_dr - dr, dr * cur_dr)
end

egyptian_fraction(100,13)
