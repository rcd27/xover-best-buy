import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MainTest {

  private int n = 4;
  private int L = 12;


  @Test
  public void mainTest() {
    long result = Main.findHowMuchCentsToSpend(n, L, new long[4]);
    long expected = 150;
    assertEquals(expected, result);
  }

  @Test
  public void fillDataTest() {
    long price[] = new long[]{20, 30, 70, 90};
    long[][] result = Main.fillData(n, L, price);
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
    double actual[] = Main.liters(4);
    assertThat(actual).containsExactly(expected);
  }
}
