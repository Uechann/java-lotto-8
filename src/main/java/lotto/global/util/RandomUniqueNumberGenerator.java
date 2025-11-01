package lotto.global.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUniqueNumberGenerator implements NumberGenerator {
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 45;
    private static final int COUNT_NUMBER = 6;

    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER, COUNT_NUMBER);
    }
}
