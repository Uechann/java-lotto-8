package lotto.domain.model;

import lotto.global.constant.ErrorMessage;

public record PurchasePrice(int value) {

    public PurchasePrice {
        validate(value);
    }

    private void validate(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_UNIT.getMessage());
        }
    }
}
