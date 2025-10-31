package lotto.global.constant;

public enum ErrorMessage {

    BLANK_IS_NOT_ALLOWED("빈칸이나 공백은 허용되지 않습니다."),
    ZERO_IS_NOT_ALLOWED("0은 허용되지 않습니다"),
    NEGATIVE_NUMBER_IS_NOT_ALLOWED("음수는 허용되지 않습니다."),
    CHARACTER_IS_NOT_ALLOWED("문자는 허용되지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
