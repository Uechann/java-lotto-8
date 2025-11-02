package lotto.domain.service;

import lotto.domain.model.*;
import lotto.global.util.NumberGenerator;

import java.util.List;

public class LottoFactory {

    private final NumberGenerator numberGenerator;

    public LottoFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    // 당첨 번호 생성기
    public WinningLotto createWinningLotto(List<Integer> winningnumbers, int bonusNumber) {
        Lotto lotto = new Lotto(winningnumbers);
        BonusNumber bonusNumberBonus = new BonusNumber(bonusNumber);
        return new WinningLotto(lotto, bonusNumberBonus);
    }

    // 로또 번호 생성기
    public Lottos createLottos(PurchasePrice purchasePrice) {
        // 가격으로 로또 개수 설정
        int lottoCount = purchasePrice.getLottoCount();
        Lottos lottos = new Lottos();

        for (int i = 0; i < lottoCount; i++) {
            List<Integer> list = generateNumbersAndSortToList();
            lottos.addLotto(new Lotto(list));
        }
        return lottos;
    }

    private List<Integer> generateNumbersAndSortToList() {
        return numberGenerator.generate().stream()
                .sorted()
                .toList();
    }
}
