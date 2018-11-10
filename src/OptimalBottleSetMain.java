
import java.util.ArrayList;

public class OptimalBottleSetMain {

  public static void main(String... args) {
    int requiredVolume = 787787787;
    long[] prices = {123456789, 234567890, 345678901, 456789012, 987654321};

    long[] result = findOptimalBottleSet(requiredVolume, prices);
    System.out.println("Required volume = " + requiredVolume);
    print(result);
    System.out.println("Total price = " + calculteTotalPrice(prices, result));
  }

  private static long[] findOptimalBottleSet(int requiredVolume, long[] prices) {
    ArrayList<Integer> bottleIdxOrderByAvgPrice = new ArrayList<Integer>();

    int currentIdx = prices.length - 1;
    while (currentIdx >= 0) {
      int idxWithMinAvgPrice = currentIdx;
      double minAvgPrice = (double) prices[idxWithMinAvgPrice] / Math.pow(2, idxWithMinAvgPrice);

      for (int i = idxWithMinAvgPrice - 1; i >= 0; i--) {
        double avgPrice = (double) prices[i] / Math.pow(2, i);
        if (avgPrice < minAvgPrice) {
          idxWithMinAvgPrice = i;
          minAvgPrice = avgPrice;
        }
      }

      if (idxWithMinAvgPrice == currentIdx || prices[idxWithMinAvgPrice] < prices[currentIdx]) {
        bottleIdxOrderByAvgPrice.add(idxWithMinAvgPrice);
      }

      currentIdx = idxWithMinAvgPrice - 1;
    }

    int optimalBottleByAvgPriceIdx = bottleIdxOrderByAvgPrice.get(0);
    int optimalBottleByAvgPriceVol = (int) Math.pow(2, optimalBottleByAvgPriceIdx);
    int remainder = requiredVolume % optimalBottleByAvgPriceVol;

    long[] optimalBottleSet = new long[prices.length];

    long countOptimalBottleByAvgPrice = (long) Math
        .floor((double) requiredVolume / optimalBottleByAvgPriceVol);
    if (remainder == 0) {
      optimalBottleSet[optimalBottleByAvgPriceIdx] = countOptimalBottleByAvgPrice;
      return optimalBottleSet;
    } else {
      optimalBottleSet[optimalBottleByAvgPriceIdx] = countOptimalBottleByAvgPrice + 1;
    }

    long optimalPrice = prices[optimalBottleByAvgPriceIdx];
    long[] curBottleSet = optimalBottleSet.clone();
    long curPrice = optimalPrice;

    int position = 0;
    while (remainder != 0 && position < bottleIdxOrderByAvgPrice.size() - 1) {
      int idx = bottleIdxOrderByAvgPrice.get(position);
      int nextIdx = bottleIdxOrderByAvgPrice.get(position + 1);

      int vol = (int) Math.pow(2, nextIdx);
      int countBottle = (int) Math.ceil((double) remainder / vol);

      remainder = remainder % vol;
      curBottleSet[idx] = curBottleSet[idx] - 1;
      curBottleSet[nextIdx] = countBottle;
      curPrice = curPrice - prices[idx] + prices[nextIdx] * countBottle;

      if (curPrice < optimalPrice) {
        optimalBottleSet = curBottleSet.clone();
        optimalPrice = curPrice;
      }

      position++;
    }

    return optimalBottleSet;
  }

  private static void print(long[] items) {
    for (int i = 0; i < items.length; i++) {
      System.out.println((int) Math.pow(2, i) + " - " + items[i]);
    }
  }

  private static long calculteTotalPrice(long[] prices, long[] data) {
    long total = 0;
    for (int i = 0; i < prices.length; i++) {
      total += prices[i] * data[i];
    }

    return total;
  }
}
