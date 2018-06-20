# https://www.interviewbit.com/problems/excel-column-number/

class Solution
    # @param a : string
    # @return an integer
    def titleToNumber(a)
        n = 0
        zero_ord = 'A'.ord - 1
        a.each_char do |c|
            ord = c.ord - zero_ord
            n = n * 26 + ord
        end

        n
    end
end
