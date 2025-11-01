package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2000000000L, (m, b) -> m == 6),
    SECOND(30000000L, (m, b) -> m == 5 && b),
    THIRD(1500000L, (m, b) -> m == 5 && !b),
    FOURTH(50000L, (m, b) -> m == 4),
    FIFTH(5000L, (m, b) -> m == 3),
    NONE(0L, (m, b) -> false);

    private final Long prize;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(Long prize, BiPredicate<Integer, Boolean> condition) {
        this.prize = prize;
        this.condition = condition;
    }

    public static Rank judgeRank(int matchCount, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.condition.test(matchCount, bonusMatch))
                .findFirst()
                .orElse(NONE);
    }

    public Long getPrize() {
        return prize;
    }
}