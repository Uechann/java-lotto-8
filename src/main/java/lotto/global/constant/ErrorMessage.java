package lotto.global.constant;

public enum ErrorMessage {

    // 구매 가격
    BLANK_IS_NOT_ALLOWED("[ERROR] 빈칸이나 공백은 허용되지 않습니다."),
    ZERO_IS_NOT_ALLOWED("[ERROR] 0은 허용되지 않습니다"),
    NEGATIVE_NUMBER_IS_NOT_ALLOWED("[ERROR] 음수는 허용되지 않습니다."),
    CHARACTER_IS_NOT_ALLOWED("[ERROR] 문자는 허용되지 않습니다."),
    IS_NOT_ALLOWED_UNIT("[ERROR] 구매 가격은 1000원 단위로 구매 가능합니다."),

    // 로또 번호
    IS_NOT_ALLOWED_PATTERN("[ERROR] 숫자들 포맷에 맞지 않습니다."),
    IS_NOT_ALLOWED_NUMBER_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    IS_NOT_ALLOWED_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER_IS_NOT_ALLOWED("[ERROR] 중복된 숫자는 허용되지 않습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
