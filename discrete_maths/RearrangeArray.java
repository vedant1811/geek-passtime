// https://www.interviewbit.com/problems/rearrange-array/

public class Solution {
	public void arrange(ArrayList<Integer> a) {
	    int n = a.size();
	    for (int i = 0; i < n; i++) {
	        int oldN = a.get(i) % n;
	        int newN = a.get(oldN) % n;
	        a.set(i, newN * n + oldN);
	    }
	    for (int i = 0; i < n; i++) {
	        a.set(i, a.get(i)/n);
	    }
	}
}
