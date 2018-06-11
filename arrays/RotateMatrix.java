// https://www.interviewbit.com/problems/rotate-matrix/

public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size()/2; i++) {
            t1(a, i);
            t2(a, i);
            t3(a, i);
        }
    }

    private void t1(ArrayList<ArrayList<Integer>> a, int layer) {
        int last = a.size() - 1 - layer;
        for (int i = layer; i < last; i++) {
            swap(a, layer, i,    i, last);
        }
    }

    private void t2(ArrayList<ArrayList<Integer>> a, int layer) {
        int last = a.size() - 1 - layer;
        int j = last;
        for (int i = layer; i < last; i++) {
            swap(a, layer, i,    last, j);
            j--;
        }
    }

    private void t3(ArrayList<ArrayList<Integer>> a, int layer) {
        int last = a.size() - 1 - layer;
        int j = last;
        for (int i = layer; i < last; i++) {
            swap(a, layer, i,    j, layer);
            j--;
        }
    }

    private void swap(ArrayList<ArrayList<Integer>> a, int r1, int c1, int r2, int c2) {
        int temp = a.get(r1).get(c1);
        a.get(r1).set(c1, a.get(r2).get(c2));
        a.get(r2).set(c2, temp);
    }
}
