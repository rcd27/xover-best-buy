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
      // Use greedy algorithm
      int remainingWeight = L - curWeight;
      long amountOfCheapestBottlesFit = remainingWeight / w[currentBottle];
      long currentBottleValue = c[currentBottle];
      if (amountOfCheapestBottlesFit >= 1) {
        currentValue += currentBottleValue * amountOfCheapestBottlesFit;
        curWeight += w[currentBottle] * amountOfCheapestBottlesFit;
      }
      // Find best price for remaining weight using dynamic approach
      if (remainingWeight < w[currentBottle]) {
        long minimumCost[][] = new long[n + 1][remainingWeight + 1];
        for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= remainingWeight; j++) {
            minimumCost[0][j] = Long.MAX_VALUE;
            if (w[i - 1] > j) { // bottle has more liters than we need
              minimumCost[i][j] = Math.min(minimumCost[i - 1][j], c[i - 1]);
            } else {
              minimumCost[i][j] = Math.min(minimumCost[i - 1][j],
                  minimumCost[i][(int) (j - w[i - 1])] + c[i - 1]);
            }
          }
        }

        long bestPrice = minimumCost[n][remainingWeight];
        return currentValue + bestPrice;
      }
    }

    return currentValue;
  }
}
