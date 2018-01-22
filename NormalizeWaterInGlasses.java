// LALLU's TROUBLE
// Since this is the month of June, and the weather here in Allahabad is is quite hot. So Ankur(aka BHAI)
// decides to drink shake at Lallu with some of his friends. Due to heavy crowd at the shop, Lallu fills each
// glass hastily and so each glass will have any random amount of shake in it. But all the friends want to have
// maximum amount of shake in their glass. For doing this, they form a queue and the one standing first in the
// queue(who will obviously be our BHAI) gets the maximum amount of shake, and each consecutive person standing
// next in the line will get a strictly lesser quantity of shake in his glass. There are n glasses of shake and
// the ith glass will have Ai amount of shake in it.
// Since BHAI(who is first in queue) is standing in front of nth glass, the nth glass should have maximum amount
// and each preceding glass should have strictly lesser amount than its successive glass. Thus glass 1 should have
// minimum amount and glass n should have maximum amount in it.
// As Lallu initially filled all glasses randomly, he is now required to make the amount filled in glasses in strictly increasing order.
// To accomplish this, Lallu can alter the amount in any glass by a value of atmost X . Here alter means he can either increase or decrease the amount.
// Ex- if X=2, he can increase or decrease the amount in any glass by 0, 1 or 2.
// Remember, 0 means he can also leave the amount unchanged in any glass if required.
// Also, the amount in any glass cannot be less than 1.
// Since Lallu is very busy, your task is to tell Lallu the minimum value of X with which the task can be
// done.
// INPUT-
// First line contains no. of testcases 't'.
// Now 't' testcases follow.
// First line of each test case will be 'n'(the number of friends or shake glasses).
// Then 'n' lines follow, where ith line contains an integer Ai equal to the amount of shake in ith glass.
// OUTPUT-
// Output 't' lines, each line containing the value of X for that testcase.
// Constraints-
// t<200
// 2<=n<=50
// 1<= Ai <= 1,000,000,000
// Sample Input- 2
// 3
// 9
// 5 11 2 5 8
// Sample Output-
// 3 0
// Explanation-
// 1.
// When 3 glassed containing having amounts 9,5,11. One solution can be-
// • Decrease amount in first glass by 2.
// • Increase amount in second glass by 3.
// • Third glass unchanged.
// Resulting in 7,8,11 and since maximum alter amount is 3(for second glass), X is 3.
// 2.
// Amounts already in strictly increasing order (5,8) so X=0.
// Time Limit- 1sec

class Main {
  public static int normalize(int[] glasses) {
    if (glasses == null || glasses.length <= 1) return 0;

    int x, xMax = 0, diff;
    for (int i = 0; i < glasses.length - 1; i++) {
      // now x will be updated
      int diff = glasses[i] - glasses[i + 1];
      x = diff/2 + 1;
      // assume every glasses[j] (where j <= i) has been reduced by x
      glasses[i + 1] += x - 1;

      if (x > xMax) xMax = x;
    }
    return xMax;
  }

  public static void main(String[] args) {
    System.out.println("normalized " + normalize([9, 5, 11]));
  }
}
