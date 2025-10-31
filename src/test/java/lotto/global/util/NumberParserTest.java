package lotto.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberParserTest {

    private final NumberParser numberParser = new NumberParser();

    @DisplayName("숫자들이 , 콤마를 구분자로 파싱할때 파싱후 숫자 범위에 맞는지 검증하고 int로 잘 변환 되는지 테스트합니다..")
    @Test
    void 숫자들_파싱_검증_테스트() {
        String input = "1,2,3,4,5";

        List<Integer> numbers = numberParser.parse(input);

        assertThat(numbers).hasSize(5);
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5);
    }
}
