public class ContinuousKnapsack {

  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
    long[] w = Utils.liters(n); // length = n
    long[] v = c; // length = n
    int W = L;

    double[] p = new double[n];
    for (int i = 0; i < n; i++) {
      double currentP = (double) v[i] / w[i];
      p[i] = currentP;

    }
    return 100;
  }


  static double[] bubbleSort(double[] x) {
    int n = x.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (x[j] > x[j + 1]) {
          // swap temp and arr[i]
          double temp = x[j];
          x[j] = x[j + 1];
          x[j + 1] = temp;
        }
      }
    }
    return x;
  }
}
