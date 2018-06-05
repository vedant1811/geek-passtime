// interviewbit question

public class Solution {
    public ArrayList<ArrayList<Integer>> generateMatrix(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<Integer>());
            for (int j = 0; j < n; j++) ans.get(i).add(0);
        }

        int num = 1, i = 0;
        while (i <= n / 2) {
            num = fillSquare(i, num, n, ans);
            i++;

        }

        return ans;
    }

    private int fillSquare(int startI, int startN, int n, ArrayList<ArrayList<Integer>> ans) {
        int num = startN;
        int max = n - startI - 1;
        for (int i = startI; i <= max; i++) {

            ans.get(startI).set(i, num++);
        }

        for (int i = startI + 1; i < max; i++) {

            ans.get(i).set(max, num++);
        }
        for (int i = max; i > startI; i--) {

            ans.get(max).set(i, num++);
        }
        for (int i = max; i > startI; i--) {

            ans.get(i).set(startI, num++);
        }
        return num;
    }
}
