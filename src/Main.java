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
      c[i] = in.nextLong();
    }

    // call findHowMuchCentsToSpend function
    long result = findHowMuchCentsToSpend(n, L, c);

    System.out.println(result);
  }

  /**
   * Complete the function below. DONOT MODIFY anything outside this function!
   */
  static long findHowMuchCentsToSpend(int n, int L, long[] c) {
    long[][] data = fillData(n, L, c); // n - кол-во видов, L- количество литров

    return 150;
  }

  static long[][] fillData(int n, int l, long[] prices) {
    double liters[] = liters(n);

    long[][] result = new long[n][l + 1];
    for (int i = 0; i < result.length; i++) {
      double stepLength = liters[i];
      int currentStep = 0;
      for (int j = 0; j < result[i].length; j++) {
        if (j % stepLength == 0) {
          result[i][j] = (long) (j / liters[i] * prices[i]);
          currentStep++;
        } else {
          result[i][j] = currentStep * prices[i];
        }
      }
    }
    return result;
  }

  static double[] liters(int amountOfBottlesTypes) {
    double result[] = new double[amountOfBottlesTypes];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.pow(2, i);
    }
    return result;
  }
}
