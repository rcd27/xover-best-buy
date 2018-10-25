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

    // Bubble sort
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (p[j] > p[j + 1]) {
          // sort p[i]
          double tempP = p[j];
          p[j] = p[j + 1];
          p[j + 1] = tempP;

          // sort w[i]
          long tempW = w[j];
          w[j] = w[j + 1];
          w[j + 1] = tempW;

          // sort v[i]
          long tempV = v[j];
          v[j] = v[j + 1];
          v[j + 1] = tempV;
        }
      }
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
