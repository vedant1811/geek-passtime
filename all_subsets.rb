# All subsets of a set https://www.youtube.com/watch?v=bGC2fNALbNU

def ith_subset(subset, i)
  if i == @set.size
    puts subset.join(',')
    return
  end
  ith_subset subset, i + 1
  ith_subset subset + [@set[i]], i + 1
end

def subsets(set)
  @set = set
  ith_subset [], 0
end

subsets [1, 2, 3]
