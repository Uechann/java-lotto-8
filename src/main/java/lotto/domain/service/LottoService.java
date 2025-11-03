package lotto.domain.service;

import lotto.domain.model.Lottos;
import lotto.domain.model.PurchasePrice;
import lotto.domain.model.WinningLotto;
import lotto.domain.rule.GameRule;
import lotto.domain.rule.result.RankResult;
import lotto.global.util.Parser;

public class LottoService {

    private final LottoFactory lottoFactory;
    private final Parser<Integer> parser;

    public LottoService(LottoFactory lottoFactory, Parser<Integer> parser) {
        this.lottoFactory = lottoFactory;
        this.parser = parser;
    }

    // 로또 발행
    public Lottos purchaseLottos(PurchasePrice price) {
        return lottoFactory.createLottos(price);
    }

    // 당첨 로또 생성
    public WinningLotto createWinningLotto(String winningLotto, String bonusLotto) {
        return lottoFactory.createWinningLotto(parser.parse(winningLotto), Integer.parseInt(bonusLotto));
    }

    // 당첨 로또와 비교 후 매칭카운트, 보너스 히트 판별
    public RankResult judgeLottosRanks(Lottos lottos, WinningLotto winningLotto) {
        GameRule lottoGameRule = GameRuleFactory.createLottoGameRule();
        return lottos.judgeLottosWithWinningLotto(winningLotto, lottoGameRule);
    }
}