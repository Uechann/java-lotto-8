package lotto.domain.model;

import lotto.global.constant.ErrorMessage;

import static lotto.global.constant.LottoConstant.LOTTO_UNIT;

public record PurchasePrice(int value) {

    public PurchasePrice {
        validate(value);
    }

    public int getLottoCount() {
        return value / LOTTO_UNIT;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if (value % LOTTO_UNIT != 0) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_UNIT.getMessage());
        }
    }
}
