package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2000000000L, (matchCount, b) -> matchCount == 6),
    SECOND(30000000L, (matchCount, b) -> matchCount == 5 && b),
    THIRD(1500000L, (matchCount, b) -> matchCount == 5 && !b),
    FOURTH(50000L, (matchCount, b) -> matchCount == 4),
    FIFTH(5000L, (matchCount, b) -> matchCount == 3),
    NONE(0L, (matchCount, b) -> false);

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