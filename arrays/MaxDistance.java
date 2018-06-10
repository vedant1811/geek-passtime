// https://www.interviewbit.com/problems/max-distance/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if (A == null || A.size() == 0) return -1;
        if (A.size() == 1) return 0;

        int bucketSize = (int) Math.sqrt(A.size());
        int nBuckets = (int) Math.ceil(A.size() / ((double)bucketSize) );

        int[] minBucket = new int[nBuckets];

        for (int i = 0; i < nBuckets; i++) {
            int min = Integer.MIN_VALUE;
            for (int j = bucketSize * i; j < bucketSize * (i+1) && j < A.size(); j++) {
                min = Math.min(min, A.get(j));
            }
            minBucket[i] = min;
        }

        for (int i = A.size() - 1; i >= 0; i--) {

            int curBucket = i/bucketSize;

            for (int j = 0; j < curBucket; j++) {
                if (minBucket[j] > A.get(i)) continue;

                for (int k = j * bucketSize; k <= j * (bucketSize + 1); k++) {
                    if (A.get(k) <= A.get(i)) return i - k;
                }
            }

            for (int j = curBucket * bucketSize; j < i; j++) {
                if (A.get(j) <= A.get(i)) return i - j;
            }
        }
        return -1;
    }
}
