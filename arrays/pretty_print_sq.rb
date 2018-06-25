# https://www.interviewbit.com/problems/prettyprint/

class Solution
    # @param n : integer
    # @return an array of array of integers
    def prettyPrint(n)
        @size = n * 2 - 1
        @maxI = n
        @a = Array.new(@size) { |c| Array.new(@size) }
        (1..n).each { |i| square(i) }
        @a
    end

    def square(i)
        start = @maxI - i
        last = @size - 1 - start
        (start..last).each do |x|
            @a[start][x] = i
            @a[last][x] = i
            @a[x][last] = i
            @a[x][start] = i
        end
    end
end
