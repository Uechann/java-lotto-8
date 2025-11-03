package lotto.domain.rule.result;

public record MatchResult(int matchCount, boolean bonusHit) {

    public static MatchResult of(int matchCount, boolean bonusHit) {
        return new MatchResult(matchCount, bonusHit);
    }
}
