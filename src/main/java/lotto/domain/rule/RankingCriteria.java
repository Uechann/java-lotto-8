package lotto.domain.rule;

public interface RankingCriteria {
    Rank judge(MatchResult matchResult);
}
