package lotto.domain.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        numbers.forEach(this::isNumberInRange);
        validateDuplicatedNumber(numbers);
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (numbers.size() != countDistinctNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 허용되지 않습니다.");
        }
    }

    private Long countDistinctNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count();
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void isNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
