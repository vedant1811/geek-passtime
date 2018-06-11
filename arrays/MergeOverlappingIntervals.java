// https://www.interviewbit.com/problems/merge-overlapping-intervals/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

import java.util.*;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;

        Collections.sort(intervals, (i1, i2) -> {
            if (i1.start != i2.start) return i1.start - i2.start;
            return i1.end - i2.end;
        });

        Iterator<Interval> i = intervals.iterator();
        Interval last = i.next();
        while (i.hasNext()) {
            Interval cur = i.next();

            if (isBetween(last.end, cur.start, cur.end)) {
                last.end = cur.end;
                i.remove();
            } else if (isBetween(cur.end, last.start, last.end)) {
                i.remove();
            } else {
                last = cur;
            }
        }

        return intervals;
    }

    private static boolean isBetween(int is, int l, int r) {
        return is >= l && is <= r;
    }
}
