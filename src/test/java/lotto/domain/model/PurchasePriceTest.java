package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceTest {

    @DisplayName("구매 가격이 단위에 맞지 않을때 오류 테스트")
    @Test
    void 구매_가격_단위_오류_테스트() {
        assertThatThrownBy(() -> new PurchasePrice(1234) )
                .isInstanceOf(IllegalArgumentException.class);
    }
}
