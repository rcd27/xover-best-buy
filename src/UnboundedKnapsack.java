import static java.lang.Math.max;

public class UnboundedKnapsack {

  private static int unboundedKnapsack(int W, int n, int[] val, int[] wt) {

    int maximumValues[] = new int[W + 1];

    for (int i = 0; i <= W; i++) {
      for (int j = 0; j < n; j++) {
        int currentBottleWeight = wt[j];
        if (currentBottleWeight <= i) { // если вес бутылки меньше текущей итерации
          int iMinusWeight = i - currentBottleWeight;
          int currentValue = val[j];
          int newCompare = maximumValues[iMinusWeight] + currentValue;
          int currentMax = maximumValues[i];
          maximumValues[i] = max(currentMax, newCompare); // максимльное значение между текущим и
        }
      }
    }
    return maximumValues[W];
  }

  // Driver program
  public static void main(String[] args) {
    int W = 12;
    int val[] = {20, 30, 70, 90};
    int wt[] = {1, 2, 4, 8};
    int n = val.length;
    System.out.println(unboundedKnapsack(W, n, val, wt));
  }
}