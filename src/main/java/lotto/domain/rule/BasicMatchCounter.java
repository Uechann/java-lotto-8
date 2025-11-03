package lotto.domain.rule;

import java.util.List;

public class BasicMatchCounter implements MatchCounter {
    @Override
    public int count(List<Integer> winningLotto, List<Integer> playerLotto) {
        return (int) playerLotto.stream()
                .filter(winningLotto::contains)
                .count();
    }
}
