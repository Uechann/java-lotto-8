package lotto;

import lotto.controller.LottoController;
import lotto.domain.service.LottoFactory;
import lotto.domain.service.LottoService;
import lotto.global.util.NumberParser;
import lotto.global.util.RandomUniqueNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(
                new LottoService(new LottoFactory(new RandomUniqueNumberGenerator())),
                new InputView(),
                new OutputView(),
                new NumberParser());

        lottoController.run();
    }
}
