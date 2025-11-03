package lotto.domain.rule;

import java.util.List;

public interface BonusCriteria {
    boolean judge(int bonusNumber, List<Integer> playerLotto);
}
