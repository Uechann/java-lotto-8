package lotto.domain.service;

import lotto.domain.model.Lottos;
import lotto.domain.model.PurchasePrice;
import lotto.domain.model.WinningLotto;
import lotto.domain.result.RankResult;

public class LottoService {

    private final LottoFactory lottoFactory;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    // 로또 발행
    public Lottos purchaseLottos(PurchasePrice price) {
        return lottoFactory.createLottos(price);
    }

    // 당첨 로또 생성

    // 당첨 로또와 비교 후 매칭카운트, 보너스 히트 판별 각 로또에 Rank 저장
    public RankResult judgeLottosRanks(Lottos lottos, WinningLotto winningLotto) {
        return lottos.judgeLottosWithWinningLotto(winningLotto);
    }

    // 등수에 따른 가격 계산 후 수익률 발행 -> Lottos 클래스에서 수익률 발행
}
