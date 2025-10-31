package lotto.global.util;

import lotto.global.constant.ErrorMessage;

public class InputValidator {

    // 가격 검증 메서드
    public static boolean validateInputPrice(String input) {

        validateNullOrBlank(input);
        validateIsZero(input);
        validateIsNegativeNumber(input);
        validateIsNotAllNumber(input);

        return true;
    }

    public static boolean validateWinningNumbers(String input) {
        validateNullOrBlank(input);
        validateNumbersPattern(input);

        return true;
    }

    private static void validateNumbersPattern(String input) {
        if (!input.matches("^[1-9]+(?:,[1-9])*$")) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_PATTERN.getMessage());
        }
    }

    private static void validateIsNotAllNumber(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(ErrorMessage.CHARACTER_IS_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateIsNegativeNumber(String input) {
        if (input.matches("^-[0-9]$")) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_IS_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateIsZero(String input) {
        if (input.equals("0")) {
            throw new IllegalArgumentException(ErrorMessage.ZERO_IS_NOT_ALLOWED.getMessage());
        }
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_IS_NOT_ALLOWED.getMessage());
        }
    }
}
