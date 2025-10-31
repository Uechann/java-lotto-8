package lotto.domain.model;

public class PurchasePrice {
    private int value;
    
    public PurchasePrice(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value % 1000 != 0) {
            throw new IllegalArgumentException("구매 가격은 1000원 단위여야합니다.");
        }
    }
}
