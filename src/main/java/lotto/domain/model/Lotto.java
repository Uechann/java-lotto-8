package lotto.domain.model;

import lotto.domain.rule.GameRule;
import lotto.domain.rule.Rank;
import lotto.global.constant.ErrorMessage;

import java.util.List;

import static lotto.global.constant.LottoConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    // GameRule을 통해 당첨 판단 후 Rank를 반환 메서드
    public Rank judgeMatchingCountAndBonusHit(WinningLotto winningLotto, GameRule gameRule) {
        return gameRule.judge(winningLotto, this);
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        numbers.forEach(this::isNumberInRange);
        validateDuplicatedNumber(numbers);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != countDistinctNumber(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_IS_NOT_ALLOWED.getMessage());
        }
    }

    private Long countDistinctNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_SIZE.getMessage());
        }
    }

    private void isNumberInRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_RANGE.getMessage());
        }
    }
}
