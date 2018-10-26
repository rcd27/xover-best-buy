public class ContinuousKnapsack {

  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
    long[] w = Utils.liters(n); // length = n

    double[] r = new double[n];
    for (int i = 0; i < n; i++) {
      r[i] = (double) c[i] / w[i];
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
          long tempV = c[j];
          c[j] = c[j + 1];
          c[j + 1] = tempV;
        }
      }
    }

    int curWeight = 0;
    long currentValue = 0;

    long amountOfCheapestBottlesFit = L / w[0];
    if (amountOfCheapestBottlesFit >= 1) {
      currentValue += c[0] * amountOfCheapestBottlesFit;
      curWeight += w[0] * amountOfCheapestBottlesFit;
      c[0] = Integer.MAX_VALUE; // sort out current bottle type
      return currentValue + findHowMuchCentsToSpend(n - 1, L - curWeight, c);
    } else {
      return 0;
    }
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
