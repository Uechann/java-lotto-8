package lotto.domain.service;

import lotto.domain.model.Lottos;
import lotto.domain.model.PurchasePrice;
import lotto.domain.model.WinningLotto;
import lotto.global.util.RandomUniqueNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    LottoFactory lottoFactory = new LottoFactory(new RandomUniqueNumberGenerator());

    // 당첨 번호 생성기로 여기서 해야할까 ?
    @Test
    void 당첨_번호_생성기_메서드_테스트() {
        // Given
        List<Integer> number = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // When
        WinningLotto winningLotto = LottoFactory.createWinningLotto(number, bonusNumber);

        // Then
        assertThat(winningLotto.getLotto()).hasSize(6);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }


    // 입력받은 가격만큼 로또의 개수 발행해야한다.
    @DisplayName("입력받은 가격만큼 로또의 개수를 발행하는 테스트를 구현한다.")
    @Test
    void 구매_가격만큼_로또를_생성하는_테스트() {
        PurchasePrice price = new PurchasePrice(8000);

        Lottos lottos = lottoFactory.createLottos(price);
        assertThat(lottos.getLottoNumbers()).hasSize(8);
    }
}
