package lotto.domain.model;

import lotto.global.constant.ErrorMessage;

import java.util.List;

public class WinningLotto {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.getValue();
    }

    // 중복 검사 메서드
    private void validate(Lotto lotto, BonusNumber bonusNumber) {
        List<Integer> numbers = lotto.getNumbers();

        numbers.forEach(number -> {
            isSameNumber(number, bonusNumber.getValue());
        });
    }

    private static void isSameNumber(Integer number, int value) {
        if (number == value) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER_IS_NOT_ALLOWED.getMessage());
        }
    }
}
