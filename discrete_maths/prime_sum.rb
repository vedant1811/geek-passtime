# https://www.interviewbit.com/problems/prime-sum/

class Solution

    # @param a : integer
    # @return an array of integers
    def primesum(a)
        @numbers = {}

        n = (2...a).find { |i| prime?(i) && prime?(a-i) }
        [n, a-n]
    end

    def prime?(n)
        return @numbers[n] if @numbers.key?(n)

        ans = !(2..Math.sqrt(n)).any? { |i| n % i == 0 }
        @numbers[n] = ans
        ans
    end
end
