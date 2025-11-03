package lotto.domain.rule;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2000000000L, 6),
    SECOND(30000000L, 5),
    THIRD(1500000L, 5),
    FOURTH(50000L, 4),
    FIFTH(5000L, 3),
    NONE(0L, 0);

    private final Long prize;
    private final int matchCount;

    Rank(Long prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public Long getPrize() {
        return prize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(matchCount).append("개 일치");

        if (Rank.SECOND.equals(this)) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (").append(String.format("%,d", prize)).append("원)");
        return builder.toString();
    }
}