package lotto.domain.rule;

import java.util.List;

public interface MatchCounter {
    int count(List<Integer> winningLotto, List<Integer> playerLotto);
}
