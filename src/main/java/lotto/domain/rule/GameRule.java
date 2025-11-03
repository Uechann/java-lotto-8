package lotto.domain.rule;

import lotto.domain.model.Lotto;
import lotto.domain.model.WinningLotto;

public interface GameRule {
    Rank judge(WinningLotto winningLotto, Lotto lotto);
}
