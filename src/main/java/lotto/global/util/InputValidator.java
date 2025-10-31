package lotto.global.util;

public class InputValidator {

    public static boolean validateInputPrice(String input) {

        // null값, 빈값, 공백시 오류 처리
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }

        // 0이라면 오류 처리
        if (input.equals("0")) {
            throw new IllegalArgumentException();
        }

        // 음수라면 오류 처리
        if (input.matches("^-[0-9]$")) {
            throw new IllegalArgumentException("음수는 안됩니다");
        }

        // 패턴으로 모두 숫자가 아니면 오류 처리
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException();
        }

        return true;
    }
}
