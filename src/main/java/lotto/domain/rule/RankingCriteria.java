package lotto.domain.rule;

import lotto.domain.rule.result.MatchResult;

public interface RankingCriteria {
    Rank judge(MatchResult matchResult);
}
