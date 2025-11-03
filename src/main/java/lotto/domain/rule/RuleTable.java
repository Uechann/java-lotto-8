package lotto.domain.rule;

import java.util.function.BiPredicate;

public record RuleTable(BiPredicate<Integer, Boolean> condition, Rank rank) {
    public boolean test(int matchCount, boolean bonusHit) {
        return condition.test(matchCount, bonusHit);
    }
}
