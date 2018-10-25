import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ContinuousKnapsackTest {

  private int n = 4;
  private int L = 12;
  private long[] prices = new long[]{20, 30, 70, 90};

  @Test
  public void mainTest() {
    long result = ContinuousKnapsack.findHowMuchCentsToSpend(n, L, prices);
    assertThat(result).isEqualTo(150);
  }

  @Test
  public void bubbleSortTest() {
    double[] result = ContinuousKnapsack.bubbleSort(new double[]{20, 15, 17.5, 11.25});
    double[] expected = new double[]{11.25, 15, 17.5, 20};
    assertThat(result).containsExactly(expected);
  }
}