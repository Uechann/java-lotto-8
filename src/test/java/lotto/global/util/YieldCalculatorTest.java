package lotto.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class YieldCalculatorTest {

    @DisplayName("수익률이 예상대로 계산되는지 테스트")
    @Test
    void 수익률_계산기_테스트() {
        // Given
        int purchasePrice = 9000;
        int winningPrice = 5000;

        // When
        double yield = YieldCalculator.calculate(purchasePrice, winningPrice);

        // Then
        assertThat(yield).isEqualTo(55.56);
    }
}
