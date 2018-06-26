# https://www.geeksforgeeks.org/job-sequencing-problem-set-1-greedy-algorithm/

def job_sequencing(jobs)
  jobs.sort! do |a, b|
    if a.last == b.last
      a[1] <=> b[1]
    else
      b.last <=> a.last
    end
  end

  sequence = []
  jobs.each do |job|
    job[1].downto(1) do |i|
      if sequence[i] == nil
        sequence[i] = job.first
        break
      end
    end
  end
  sequence.compact
end


jobs = [ ['a', 2, 100], ['b', 1, 19], ['c', 2, 27],
                   ['d', 1, 25], ['e', 3, 15]]

puts job_sequencing(jobs)
