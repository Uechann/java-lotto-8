package lotto.domain.model;

import lotto.domain.result.Rank;
import lotto.domain.result.RankResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    // 당첨 로또를 통해서 Rank 저장후 결과 반환 메서드
    public RankResult judgeLottosWithWinningLotto(WinningLotto winningLotto) {
        Map<Rank, Integer> rankResult = new HashMap<>();

        lottos.forEach(lotto -> {
            Rank rank = lotto.judgeMatchingCountAndBonusHit(winningLotto);
            rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
        });
        System.out.println(rankResult);

        return new RankResult(rankResult);
    }
}
