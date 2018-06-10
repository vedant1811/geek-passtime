// https://leetcode.com/contest/weekly-contest-88/problems/maximize-distance-to-closest-person/

class Main {

    public static int maxDistToClosest(int[] seats) {
        int l = 0, r = 0;

        int ans = 0;

        while (true) {
            while (l < seats.length && seats[l] == 1) l++;
            r = l;
            while (r < seats.length && seats[r] == 0) r++;

            if (seats.length == l) break;

            int dist = r - l;

            if (l > 0 && r < seats.length) dist = (dist + 1)/2;

            ans = Math.max(ans, dist);
            l++;
        }
        return ans;
    }
}
