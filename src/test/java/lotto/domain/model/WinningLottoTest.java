package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    @DisplayName("당첨 로또에 보너스 번호를 추가할때 성공하는 테스트입니다.")
    @Test
    void 당첨_로또에_보너스번호_추가_성공_테스트() {

        // Given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(7);

        // When
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);

        // Then
        assertThat(winningLotto.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("당첨 로또에 보너스 번호를 추가할때 중복으로 인한 에러 테스트입니다.")
    @Test
    void 당첨_로또에_중복된_보너스번호_추가_실패_테스트() {

        // Given
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        BonusNumber bonusNumber = new BonusNumber(6);

        // When
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
