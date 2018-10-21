import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

  private int n = 4;
  private int L = 12;
  private long[] prices = new long[]{20, 30, 70, 90};

  @Test
  public void mainTest() {
    long result = Main.findHowMuchCentsToSpend(n, L, prices);
    long expected = 150;
    assertEquals(expected, result);
  }

  @Test
  public void fillDataTest() {

    long[][] result = Main.fillData(n, L, prices);
    long[][] expected = new long[][]{
        {0, 20, 40, 60, 80, 100, 120, 140, 160, 180, 200, 220, 240},
        {0, 30, 30, 60, 60, 90, 90, 120, 120, 150, 150, 180, 180},
        {0, 70, 70, 70, 70, 140, 140, 140, 140, 210, 210, 210, 210},
        {0, 90, 90, 90, 90, 90, 90, 90, 90, 180, 180, 180, 180}
    };
    assertThat(result).containsExactly(expected);
  }

  @Test
  public void litersTest() {
    double expected[] = new double[]{1, 2, 4, 8};
    double result[] = new double[4];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.pow(2, i);
    }
    assertThat(result).containsExactly(expected);
  }

  @Test
  public void testMinimumCost() {
    long result = Main.findHowMuchCentsToSpend(n, L, prices);
    int expected = 150;

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testCornerCase() {
    long result = Main.findHowMuchCentsToSpend(4, 3, new long[]{10000, 1000, 100, 10});
    long expected = 10;

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSimple() {
    long result = Main.findHowMuchCentsToSpend(4, 3, new long[]{10, 100, 1000, 10000});
    long expected = 30;

    assertThat(result).isEqualTo(expected);
  }

  /*
  @Test
  public void testLongs() {
    long result = Main.findHowMuchCentsToSpend(5, 787787787,
        new long[]{123456789, 234567890, 345678901, 456789012, 987654321});
    long expected = 0;

    assertThat(result).isEqualTo(expected);
  }
  */
}
