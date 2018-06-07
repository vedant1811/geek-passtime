// https://leetcode.com/problems/find-the-duplicate-number/description/

class Solution {
    public int findDuplicate(int[] nums) {
        int bucketSize = (int) Math.sqrt(nums.length);
        int maxI = (int) Math.ceil(nums.length/bucketSize);
        int i; // the bucket index we need
        for (i = 0; i < maxI; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                int bucket = (nums[j]-1)/bucketSize;
                if (bucket == i) {
                    count++;
                }
            }
            if (count > bucketSize) {
                break;
            }
        }

        for (int j = 0; ; j++) {
            int bucket = (nums[j]-1)/bucketSize;
            if (bucket == i) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] == nums[k]) return nums[k];
                }
            }
        }
    }
}
