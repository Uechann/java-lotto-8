package lotto.domain.rule;

import java.util.List;

public class SingleBonusCriteria implements BonusCriteria {
    @Override
    public boolean judge(int bonusNumber, List<Integer> playerLotto) {
        return playerLotto.contains(bonusNumber);
    }
}
