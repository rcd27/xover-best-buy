public class ContinuousKnapsack {

  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
    long w[] = new long[n];
    // Some optimization instead of using Math.pow() in each iteration
    int previousPow = 1;
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        w[i] = 1;
      } else {
        w[i] = previousPow * 2;
        previousPow *= 2;
      }
    }

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
    int currentBottle = 0;

    while (curWeight < L) {
      int remainingWeight = L - curWeight;
      long amountOfCheapestBottlesFit = remainingWeight / w[currentBottle];
      long currentBottleValue = c[currentBottle];
      if (amountOfCheapestBottlesFit >= 1) {
        currentValue += currentBottleValue * amountOfCheapestBottlesFit;
        curWeight += w[currentBottle] * amountOfCheapestBottlesFit;
      }
      if (remainingWeight < w[currentBottle]) {
        // pick 1 current bottle or 2 next bottle types if they are cheaper
        // FIXME: we can also need 1 bottle of next type. Figure out that '2'
        long bestPrice = Math.min(c[currentBottle], 2 * c[currentBottle + 1]);
        currentValue += bestPrice;
        curWeight += remainingWeight;
        currentBottle++;
      }
    }
    return currentValue;
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
