package lotto.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("해당 가격이 유효한지 성공을 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "5000", "10000"})
    void 가격_입력_성공_테스트(String input) {

        boolean isValid = InputValidator.validateInputPrice(input);
        assertThat(isValid).isTrue();
    }

    @DisplayName("해당 가격이 유효한지 실패를 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"asdf", "1000j", "0", "-1"})
    void 가격_입력_실패_테스트(String input) {

        assertThatThrownBy(() -> InputValidator.validateInputPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
