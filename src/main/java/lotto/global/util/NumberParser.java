package lotto.global.util;

import java.util.Arrays;
import java.util.List;

public class NumberParser implements Parser<Integer> {

    private static final String DELIMITER = ",";

    @Override
    public List<Integer> parse(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(Integer::parseInt)
                .filter(InputValidator::validateNumberRange)
                .toList();
    }
}
