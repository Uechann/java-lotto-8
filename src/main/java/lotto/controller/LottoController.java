package lotto.controller;

import lotto.domain.model.*;
import lotto.domain.result.RankResult;
import lotto.domain.service.LottoFactory;
import lotto.domain.service.LottoService;
import lotto.global.util.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;
    private final Parser<Integer> parser;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView, Parser parser) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.parser = parser;
    }

    public void run() {
        // 구입금액 입력
        String purchasePrice = Retry.askUntilValid(outputView, inputView::InputPurchasePrice, InputValidator::validateInputPrice);
        PurchasePrice price = new PurchasePrice(Integer.parseInt(purchasePrice));

        // 로또 구매
        Lottos lottos = lottoService.purchaseLottos(price);

        // 구매 로또 내역 출력 -> 값만 전달
        outputView.printPurchaseLottos(lottos.getLottoNumbers());

        // 당첨 번호 입력
        String winningNumbers = Retry.askUntilValid(outputView, inputView::InputWinningNumbers, InputValidator::validateWinningNumbers);

        // 보너스 번호 입력
        String bonusNumber = Retry.askUntilValid(outputView, inputView::InputBonusNumber, InputValidator::validateBonusNumber);
        WinningLotto winningLotto = LottoFactory.createWinningLotto(parser.parse(winningNumbers), Integer.parseInt(bonusNumber));

        // 당첨 판단
        RankResult rankResult = lottoService.judgeLottosRanks(lottos, winningLotto);

        // 당첨 통계 출력
        outputView.printLottosStatistics(rankResult);

        // 수익률 출력
        double yield = YieldCalculator.calculate(price.getValue(), rankResult.getTotalPrize());
        outputView.printYield(yield);
    }
}
