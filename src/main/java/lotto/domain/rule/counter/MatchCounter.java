package lotto.domain.rule.counter;

import java.util.List;

public interface MatchCounter {
    int count(List<Integer> winningLotto, List<Integer> playerLotto);
}
