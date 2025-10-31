package lotto.global.util;

import lotto.global.constant.ErrorMessage;

public class InputValidator {

    // 가격 검증 메서드
    public static boolean validateInputPrice(String input) {

        validateNullOrBlank(input);
        validateIsNotAllNumber(input);
        validateIsZero(input);
        validateIsNegativeNumber(input);

        return true;
    }

    // 당첨 번호들 검증 메서드
    public static boolean validateWinningNumbers(String input) {

        validateNullOrBlank(input);
        validateNumbersPattern(input);

        return true;
    }

    // 보너스 번호 검증 메서드
    public static boolean validateBonusNumber(String input) {
        validateNullOrBlank(input);
        validateIsNotAllNumber(input);
        validateNumberRange(Integer.parseInt(input));

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

    public static boolean validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_ALLOWED_NUMBER_RANGE.getMessage());
        }

        return true;
    }
}
