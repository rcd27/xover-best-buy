import static java.lang.Math.max;

// Java program to find maximum achievable
// value with a knapsack of weight W and
// multiple instances allowed.
public class UnboundedKnapsack {

  // Returns the maximum value with knapsack
  // of W capacity
  private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {

    // dp[i] is going to store maximum value
    // with knapsack capacity i.
    int dp[] = new int[W + 1];

    // Fill dp[] using above recursive formula
    for (int i = 0; i <= W; i++) {
      for (int j = 0; j < n; j++) {
        if (wt[j] <= i) {
          dp[i] = max(dp[i], dp[i - wt[j]] + val[j]);
        }
      }
    }
    return dp[W];
  }

  // Driver program
  public static void main(String[] args) {
    int W = 100;
    int val[] = {10, 30, 20};
    int wt[] = {5, 10, 15};
    int n = val.length;
    System.out.println(unboundedKnapsack(W, n, val, wt));
  }
}
// This code is contributed by Aditya Kumar