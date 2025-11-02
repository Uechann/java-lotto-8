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

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        // 구입금액 입력 후 로또 구매
        String purchasePrice = Retry.askUntilValid(outputView, inputView::InputPurchasePrice, InputValidator::validateInputPrice);
        PurchasePrice price = new PurchasePrice(Integer.parseInt(purchasePrice));
        Lottos lottos = lottoService.purchaseLottos(price);
        outputView.printPurchaseLottos(lottos.getLottoNumbers());

        // 당첨 번호화 보너스 번호 입력
        String winningNumbers = Retry.askUntilValid(outputView, inputView::InputWinningNumbers, InputValidator::validateWinningNumbers);
        String bonusNumber = Retry.askUntilValid(outputView, inputView::InputBonusNumber, InputValidator::validateBonusNumber);
        WinningLotto winningLotto = lottoService.createWinningLotto(winningNumbers, bonusNumber);

        // 당첨 판단
        RankResult rankResult = lottoService.judgeLottosRanks(lottos, winningLotto);
        outputView.printLottosStatistics(rankResult);
        outputView.printYield(YieldCalculator.calculate(price.getValue(), rankResult.getTotalPrize()));
    }
}