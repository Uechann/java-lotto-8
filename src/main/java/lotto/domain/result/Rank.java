package lotto.domain.result;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(1, 2000000000L, 6,(matchCount, b) -> matchCount == 6),
    SECOND(2, 30000000L, 5, (matchCount, b) -> matchCount == 5 && b),
    THIRD(3, 1500000L, 5, (matchCount, b) -> matchCount == 5 && !b),
    FOURTH(4, 50000L, 4, (matchCount, b) -> matchCount == 4),
    FIFTH(5, 5000L, 3, (matchCount, b) -> matchCount == 3),
    NONE(6, 0L, 0, (matchCount, b) -> false);

    private final int rank;
    private final Long prize;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int rank, Long prize, int matchCount, BiPredicate<Integer, Boolean> condition) {
        this.rank = rank;
        this.prize = prize;
        this.matchCount = matchCount;
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