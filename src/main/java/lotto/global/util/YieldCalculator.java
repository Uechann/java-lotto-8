package lotto.global.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class YieldCalculator {
    public static double calculate(int purchasePrice, int winningPrice) {
        BigDecimal purchase = BigDecimal.valueOf(purchasePrice);
        BigDecimal winning = BigDecimal.valueOf(winningPrice);
        BigDecimal rate = winning
                .divide(purchase, 10, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return rate.setScale(1, RoundingMode.HALF_UP).doubleValue();
    }
}
