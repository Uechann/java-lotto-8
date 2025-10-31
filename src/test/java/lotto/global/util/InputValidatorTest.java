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

    // 당첨 번호 성공 테스트
    @DisplayName("당첨 번호 입력 시 성공 테스트 케이스를 검증합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5,6,7"})
    void 당첨_번호_입력_성공_테스트(String input) {
        boolean isValid = InputValidator.validateWinningNumbers(input);
        assertThat(isValid).isTrue();
    }


    // 당첨 번호 실패 테스트
    @DisplayName("당첨 번호 입력 시 실패 테스트 케이스를 검증합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "ㅁ,ㅁ,ㅁ,ㅁ,ㅁ,ㅁ", "0,1,2,3,4,5", ",1,2,3", "1,2,3,", ",1,2,3,"})
    void 당첨_번호_실패_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 보너스 번호 실패 테스트
    @DisplayName("보너스 번호 입력시 실패 테스트 케이스를 검증합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"ㅁ", "1,", "0", "46"})
    void 보너스_번호_실패_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
