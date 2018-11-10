import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

public class ContinuousKnapsackTest {

  @Test
  public void mainTest() {
    int n = 4;
    int L = 12;
    long[] prices = new long[]{20, 30, 70, 90};
    long result = ContinuousKnapsack.findHowMuchCentsToSpend(n, L, prices);
    assertThat(result).isEqualTo(150);
  }

  @Test
  public void testLongs() {
    long result = ContinuousKnapsack.findHowMuchCentsToSpend(5, 787787787,
        new long[]{123456789, 234567890, 345678901, 456789012, 987654321});
    long expected = 44981600785557577L;

    assertThat(result).isEqualTo(expected);
  }

  /**
   * В данном случае выгодно взять две двулитровые бутылки.
   */
  @Test
  public void testTricky() {
    long result = ContinuousKnapsack.findHowMuchCentsToSpend(2, 3, new long[]{10, 9});
    long expected = 18;

    assertThat(result).isEqualTo(expected);
  }

  /*
  @Test
  public void bubbleSortTest() {
    double[] result = ContinuousKnapsack.bubbleSort(new double[]{20, 15, 17.5, 11.25});
    double[] expected = new double[]{11.25, 15, 17.5, 20};
    assertThat(result).containsExactly(expected);
  }
  */

  @Test
  public void testSimple() {
    long result = ContinuousKnapsack
        .findHowMuchCentsToSpend(4, 3, new long[]{10, 100, 1000, 10000});
    long expected = 30;

    AssertionsForClassTypes.assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testCornerCase() {
    long result = ContinuousKnapsack
        .findHowMuchCentsToSpend(4, 3, new long[]{10000, 1000, 100, 10});
    long expected = 10;

    AssertionsForClassTypes.assertThat(result).isEqualTo(expected);
  }
}