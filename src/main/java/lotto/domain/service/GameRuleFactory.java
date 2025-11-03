package lotto.domain.service;

import lotto.domain.rule.*;
import lotto.domain.rule.BasicMatchCounter;
import lotto.domain.rule.Rank;
import lotto.domain.rule.SingleBonusCriteria;

import java.util.List;

public final class GameRuleFactory {
    private GameRuleFactory() {
    }

    public static GameRule createLottoGameRule() {
        RankingCriteria rankingCriteria = new LottoRankingCriteria(
                List.of(new RuleTable((m, b) -> m == 6, Rank.FIRST),
                        new RuleTable((m,b) -> m == 5 && b, Rank.SECOND),
                        new RuleTable((m,b) -> m == 5, Rank.THIRD),
                        new RuleTable((m,b) -> m == 4, Rank.FOURTH),
                        new RuleTable((m,b) -> m == 3, Rank.FIFTH)));
        return new LottoGameRule(new BasicMatchCounter(), new SingleBonusCriteria(), rankingCriteria);
    }
}
