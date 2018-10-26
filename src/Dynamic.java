import java.io.IOException;
import java.util.Scanner;

public class Dynamic {

  /*
    Магазин продаёт молоко в бутылках, `n` разных вместимостей за разные цены
    Бутылка типа `i` имеет вместимость 2^i-1 литров и стоит Ci центов
    Количество бутылок каждого типа неограничено
    Вы хотите купить как минимум L литров молока. Сколько центов вы потратите?

    Input Format:
    Первая линия содержит два инта n - количество типов бутылок, и L - необходимое количество литров
    молока.
    Вторая линия содерижт n интов c1,c2,...,c(n) - цена бутылок разного типа.

    Вывести надо наименьшую сумму, при которой можно закупиться.

    ---
    Пример:
    4 12
    20 30 70 90

    Вывод:
    150

    В этом примере вам надо купить одну восьми-литровую бутыль за 90 центов
    и две 2-литровые бутыли по 30 центов за каждую
    ---

    ---
    Пример:
    4 3
    10000 1000 100 10

    Вывод:
    10

    Даже если вам нужно 3 литра молока, дешевле всего будет купить 8-литровую бутыль за 10 центов
   */
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);

    int n = in.nextInt();
    int L = in.nextInt();

    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
      c[i] = in.nextInt();
    }

    // call findHowMuchCentsToSpend function
    long result = findHowMuchCentsToSpend(n, L, c);

    System.out.println(result);
  }

  /**
   * Complete the function below. DONOT MODIFY anything outside this function!
   */
  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
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

    // Найти количество целых бутылок с минимальной стоимостью
    // Запомнить их суммарную стоимость
    // Вернуть curTotal + findHomMuchCentsToSpend(int n-1, L-curL, long c1[n-1]

    long minimumCost[][] = new long[n + 1][L + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= L; j++) {
        minimumCost[0][j] = Integer.MAX_VALUE;
        if (liters[i - 1] > j) { // bottle has more liters than we need
          minimumCost[i][j] = Math.min(minimumCost[i - 1][j], c[i - 1]);
        } else {
          minimumCost[i][j] = Math.min(minimumCost[i - 1][j],
              minimumCost[i][(int) (j - liters[i - 1])] + c[i - 1]);
        }
      }
    }

    return minimumCost[n][L];
  }
}
