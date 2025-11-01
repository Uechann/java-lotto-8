package lotto.global.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {

    RandomUniqueNumberGenerator generator = new RandomUniqueNumberGenerator();

    @DisplayName("랜덤 숫자들 생성 테스트")
    @Test
    void 랜덤_숫자들_생성_테스트() {
        List<Integer> numbers = generator.generate();

        assertThat(numbers).hasSize(6);
        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 45);
        }
    }
}
