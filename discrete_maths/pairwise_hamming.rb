# https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/#

class Solution

    # @param a : constant array of integers
    # @return an integer
    def hammingDistance(a)
        max = a.max
        ans = 0
        mask = 1
        while mask <= max
            x = 0
            a.each do |n|
                x += 1 if mask & n != 0
            end
            y = a.size - x
            ans += x * y
            mask <<= 1
        end

        ans * 2
    end
end
