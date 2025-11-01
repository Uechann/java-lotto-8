package lotto.global.util;

import java.math.BigDecimal;

public class YieldCalculator {
    public static double calculate(int purchasePrice, int winningPrice) {
        double result = ((double) winningPrice / (double) purchasePrice) * 100;
        return BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
