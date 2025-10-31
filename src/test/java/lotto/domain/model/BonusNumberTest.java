package lotto.domain.model;

import lotto.global.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @DisplayName("보너스 숫자 입력 숫자가 형식에 맞지 않는다면 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ㅁ", "1,"})
    void 보너스_숫자가_입력_검증시_실패(String value) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 숫자 입력 숫자가 범위에 맞지 않는다면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 보너스_숫자가_입력_검증시_실패(int value) {
        assertThatThrownBy(() -> new BonusNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
