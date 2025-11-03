package lotto.domain.rule;

import static lotto.global.constant.LottoConstant.*;

public enum Rank {
    FIRST(LOTTO_FIRST_PRIZE, 6),
    SECOND(LOTTO_SECOND_PRIZE, 5),
    THIRD(LOTTO_THIRD_PRIZE, 5),
    FOURTH(LOTTO_FOURTH_PRIZE, 4),
    FIFTH(LOTTO_FIFTH_PRIZE, 3),
    NONE(0, 0);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getPrize() {
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