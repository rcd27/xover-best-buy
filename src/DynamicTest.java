import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DynamicTest {

  private int n = 4;
  private int L = 12;
  private long[] prices = new long[]{20, 30, 70, 90};

  @Test
  public void mainTest() {
    long result = Dynamic.findHowMuchCentsToSpend(n, L, prices);
    long expected = 150;
    assertEquals(expected, result);
  }

  @Test
  public void testMinimumCost() {
    long result = Dynamic.findHowMuchCentsToSpend(n, L, prices);
    int expected = 150;

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testCornerCase() {
    long result = Dynamic.findHowMuchCentsToSpend(4, 3, new long[]{10000, 1000, 100, 10});
    long expected = 10;

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void testSimple() {
    long result = Dynamic.findHowMuchCentsToSpend(4, 3, new long[]{10, 100, 1000, 10000});
    long expected = 30;

    assertThat(result).isEqualTo(expected);
  }


  @Test
  public void testLongs() {
    long result = Dynamic.findHowMuchCentsToSpend(5, 787787787,
        new long[]{123456789, 234567890, 345678901, 456789012, 987654321});
    long expected = 0;

    assertThat(result).isEqualTo(expected);
  }
}
