// interviewbit

public class Solution {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            ans.add(antiDiagonal(A, i, 0));
        }
        for (int j = 1; j < n; j++) {
            ans.add(antiDiagonal(A, n - 1, j));
        }
        return ans;
    }

    private static ArrayList<Integer> antiDiagonal(ArrayList<ArrayList<Integer>> A, int i, int j) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (i >=0 && j < A.size()) {
            list.add(A.get(j).get(i));
            i--;
            j++;
        }
        return list;
    }
}
