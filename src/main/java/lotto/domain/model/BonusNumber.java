package lotto.domain.model;

import lotto.global.constant.ErrorMessage;

public class BonusNumber {
    private int value;

    public BonusNumber(int number) {
        validate(number);
        this.value = number;
    }

    private void validate(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_RANGE.getMessage());
        }
    }
}
