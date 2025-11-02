package lotto.domain.service;

import jdk.swing.interop.SwingInterOpUtils;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningLotto;
import lotto.domain.result.Rank;
import lotto.domain.result.RankResult;
import lotto.global.util.NumberParser;
import lotto.global.util.RandomUniqueNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService(
            new LottoFactory(new RandomUniqueNumberGenerator()),
            new NumberParser());

    @DisplayName("당첨 로또를 통해서 로또들의 당첨 등수를 판별하는 메서드 테스트")
    @Test
    void 로또_당첨_통계_판별_메서드_테스트() {
        // Given
        Lotto lotto1 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto2 = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto3 = new Lotto(List.of(1,2,3,4,5,8));
        Lottos lottos = new Lottos();
        lottos.addLotto(lotto1);
        lottos.addLotto(lotto2);
        lottos.addLotto(lotto3);

        Lotto lotto4 = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto4, bonusNumber);

        // When
        RankResult rankResult = lottoService.judgeLottosRanks(lottos, winningLotto);

        // Then
        assertThat(rankResult.rankStatistics().get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankResult.rankStatistics().get(Rank.SECOND)).isEqualTo(1);
        assertThat(rankResult.rankStatistics().get(Rank.THIRD)).isEqualTo(1);
    }

}
