import java.io.IOException;
import java.util.Scanner;

public class Main {

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

  /**
   * Complete the function below. DONOT MODIFY anything outside this function!
   */
  static long findHowMuchCentsToSpend(int n, int L, long c[]) {
    long  liters[] = new long[n];
    for (int i = 0; i < liters.length; i++) {
      liters[i] = (long) Math.pow(2, i);
    }

    long minimumCost[][] = new long[n + 1][L + 1];

    for (int i = 0; i <= L; i++) { minimumCost[0][i] = Integer.MAX_VALUE; }
    for (int i = 1; i <= n; i++) { minimumCost[i][0] = 0; }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= L; j++) {
        // litters[i-1] > j - if we need less milk than bottle has
        if (liters[i - 1] > j) {
          minimumCost[i][j] = minimumCost[i - 1][j];
        } else {
          minimumCost[i][j] = Math.min(minimumCost[i - 1][j],
              minimumCost[i][(int) (j - liters[i - 1])] +
                  c[i - 1]);
        }
      }
    }

    return (minimumCost[n][L] == Integer.MAX_VALUE) ? -1 :
        minimumCost[n][L];
  }
}
