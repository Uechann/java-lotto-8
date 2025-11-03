package lotto.domain.rule;

import lotto.domain.rule.result.MatchResult;

import java.util.List;

public class LottoRankingCriteria implements RankingCriteria {

    private final List<RuleTable> rules;

    public LottoRankingCriteria(List<RuleTable> rules) {
        this.rules = rules;
    }

    @Override
    public Rank judge(MatchResult matchResult) {
        return rules.stream()
                .filter(row -> row.test(matchResult.matchCount(), matchResult.bonusHit()))
                .map(RuleTable::rank)
                .findFirst()
                .orElse(Rank.NONE);
    }
}
