package lotto.global.constant;

public enum ErrorMessage {

    // 구매 가격
    BLANK_IS_NOT_ALLOWED("빈칸이나 공백은 허용되지 않습니다."),
    ZERO_IS_NOT_ALLOWED("0은 허용되지 않습니다"),
    NEGATIVE_NUMBER_IS_NOT_ALLOWED("음수는 허용되지 않습니다."),
    CHARACTER_IS_NOT_ALLOWED("문자는 허용되지 않습니다."),
    IS_NOT_ALLOWED_UNIT("구매 가격은 1000원 단위로 구매 가능합니다."),

    // 로또 번호
    IS_NOT_ALLOWED_PATTERN("숫자들 포맷에 맞지 않습니다."),
    IS_NOT_ALLOWED_NUMBER_SIZE("로또 번호는 6개여야 합니다."),
    IS_NOT_ALLOWED_NUMBER_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_IS_NOT_ALLOWED("중복된 숫자는 허용되지 않습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
