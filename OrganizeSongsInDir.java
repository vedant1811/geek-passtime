// Google.com/Songs :
// Author-Kavish Dwivedi
// Google has decided to start an Online Music listening website and you are an engineer in its optimization team.
// You are given a list of N songs of equal length L songs(in seconds) and have to put them in some x number of directories.
// Every directory can store upto C seconds of audio. Every song must be separated by a 1 second equivalent space in
// the directory .Your team lead is very superstitious and wants you to ensure that the number of songs in a directory
// must never be divisible by 13. Given these constraints, you have to return the smallest number of directories required.
// Time limit:
// 0.5 sec
// Input:
// -T Number of test cases in first line
// -N L C in next line
// Output-
// -Number of directories required corresponding to each case and then a new line.
// Constraints:
// -N will be between 1 to 100.
// -C will be between 1 to 1000.
// -L will be between 1 to C
//
// Sample Test Case:
// Input:
// 2
// 20 1 100
// 7 2 6
// Output:
// 1
// 4

class Main {
  public static int num(int N, int L, int C) {
    double doubleN = (double) N;
    int x = (int) doubleN * (L+1) / C;
    if (x == 0) return 1;

    int n = (int) doubleN / x + 1; // number of songs per dir

    while (size(n, L) > C || n % 13 == 0) {
      n--;
    }
    int lastN = N % n;
    x = (int) Math.ceil(doubleN / n);
    if (lastN != 0 && lastN % 13 == 0) {
      if ((n - 1) % 13 == 0 || x == 1) {
        x++;
      }
    }
    return x;
  }

  private static int size(int n, int l) {
    return n * (l+1) - 1;
  }

  public static void main(String[] args) {
    System.out.println("num " + num(20, 1, 100));
    System.out.println("num " + num(1, 20, 20));
    System.out.println("num " + num(7, 2, 6));
    System.out.println("num " + num(27, 10, 155));
  }
}
