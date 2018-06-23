# https://www.interviewbit.com/problems/largest-coprime-divisor/

class Solution
    # @param a : integer
    # @param b : integer
    # @return an integer
    def cpFact(a, b)
        gcd = gcd(a, b)

        if gcd == 1
            a
        else
            cpFact(a/gcd, b)
        end
    end

    # @param a : integer
    # @param b : integer
    # @return an integer
    def gcd(a, b)
        m, n = a > b ? [b, a] : [a, b]

        return n if m == 0
        return m if n % m == 0

        gcd(n - m, m)
    end
end
