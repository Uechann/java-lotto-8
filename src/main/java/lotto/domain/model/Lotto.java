package lotto.domain.model;

import lotto.global.constant.ErrorMessage;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_SIZE.getMessage());
        }
    }

    private void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_RANGE.getMessage());
        }
    }
}
