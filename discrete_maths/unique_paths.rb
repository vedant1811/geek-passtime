# https://www.interviewbit.com/problems/grid-unique-paths/

class Solution
    # @param a : integer
    # @param b : integer
    # @return an integer
    def uniquePaths(a, b)
        r = [a-1, b-1].min
        n = a + b - 2

        nCr(n, r)
    end

    def nCr(n, r)
        product = ((n - r + 1)..n).reduce(1, :*)

        product / factorial(r)
    end

    def factorial(r)
        (2..r).reduce(1, :*)
    end
end
