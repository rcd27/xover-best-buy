public class Utils {

  static long[][] fillData(int n, int l, long[] prices) {
    double result11[] = new double[n];
    for (int i1 = 0; i1 < result11.length; i1++) {
      result11[i1] = Math.pow(2, i1);
    }

    long[][] result = new long[n][l + 1];
    for (int i = 0; i < result.length; i++) {
      double stepLength = result11[i];
      int currentStep = 0;
      for (int j = 0; j < result[i].length; j++) {
        if (j % stepLength == 0) {
          result[i][j] = (long) (j / result11[i] * prices[i]);
          currentStep++;
        } else {
          result[i][j] = currentStep * prices[i];
        }
      }
    }
    return result;
  }

  static long[] liters(int n) {
    long liters[] = new long[n];
    // Some optimization instead of using Math.pow() in each iteration
    int previousPow = 1;
    for (int i = 0; i < liters.length; i++) {
      if (i == 0) {
        liters[i] = 1;
      } else {
        liters[i] = previousPow * 2;
        previousPow *= 2;
      }
    }

    return liters;
  }
}
