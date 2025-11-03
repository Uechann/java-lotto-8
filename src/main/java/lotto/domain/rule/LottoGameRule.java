package lotto.domain.rule;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;
import lotto.domain.rule.bonus.BonusCriteria;
import lotto.domain.rule.counter.MatchCounter;
import lotto.domain.rule.result.MatchResult;

public class LottoGameRule implements GameRule {

    private final MatchCounter matchCounter;
    private final BonusCriteria bonusCriteria;
    private final RankingCriteria rankingCriteria;

    public LottoGameRule(MatchCounter matchCounter, BonusCriteria bonusCriteria, RankingCriteria rankingCriteria) {
        this.matchCounter = matchCounter;
        this.bonusCriteria = bonusCriteria;
        this.rankingCriteria = rankingCriteria;
    }

    @Override
    public Rank judge(WinningLotto winningLotto, Lotto lotto) {
        int count = matchCounter.count(winningLotto.getLotto(), lotto.getNumbers());
        boolean judge = bonusCriteria.judge(winningLotto.getBonusNumber(), lotto.getNumbers());
        MatchResult matchResult = MatchResult.of(count, judge);

        return rankingCriteria.judge(matchResult);
    }
}
