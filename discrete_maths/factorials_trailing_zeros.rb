# https://www.interviewbit.com/problems/trailing-zeros-in-factorial/

class Solution
    # @param a : integer
    # @return an integer
    def trailingZeroes(a)

        base = 5
        count = 0
        while base <= a
            count += a/base
            base *= 5
        end
        count
    end
end
