public class ContinuousKnapsack {

  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
    long[] w = Utils.liters(n); // length = n
    long[] v = c; // length = n
    int W = L;

    double[] r = new double[n];
    for (int i = 0; i < n; i++) {
      r[i] = (double) v[i] / w[i];
    }

    // Bubble sort according to value per unit weight
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (r[j] > r[j + 1]) {
          // sort r[i]
          double tempR = r[j];
          r[j] = r[j + 1];
          r[j + 1] = tempR;

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

    int curWeight = 0;
    long finalValue = 0;

    // utils
    long[] chromosome = new long[4];

    for (int i = 0; i < n; i++) {
      if (curWeight + w[i] <= W) {
        curWeight += w[i];
        finalValue += v[i];
        chromosome[i] += 1;
      } else {
        // if we can't add bottle, add the best fit to full knapsack

      }
    }
    // chromosome = {1,1,0,1}
    return finalValue;
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
