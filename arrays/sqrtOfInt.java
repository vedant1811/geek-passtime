// https://www.geeksforgeeks.org/square-root-of-an-integer/

public class Solution {
    public int sqrt(int a) {
        if (a <= 1) return a;

        return (int)sqrt(a, 1, a);
    }

    private long sqrt(int a, long start, long end) {
        if (end - start <= 0) {
            if (start * start <= a)
                return start;
            else
                return start - 1;
        }

        long mid = (start + end)/2;
        long midSq = mid * mid;

        if (midSq == a) return mid;
        else if (midSq > a) return sqrt(a, start, mid - 1);
        else return sqrt(a, mid + 1, end);
    }
}
