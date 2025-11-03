package lotto.domain.model;

import lotto.domain.rule.GameRule;
import lotto.domain.rule.Rank;
import lotto.domain.rule.result.RankResult;

import java.util.*;

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
    public RankResult judgeLottosWithWinningLotto(WinningLotto winningLotto, GameRule gameRule) {
        Map<Rank, Integer> rankResult = initializeRankMap();

        lottos.forEach(lotto -> {
            Rank rank = lotto.judgeMatchingCountAndBonusHit(winningLotto, gameRule);
            rankResult.put(rank, rankResult.getOrDefault(rank, 0) + 1);
        });

        return new RankResult(rankResult);
    }

    private Map<Rank, Integer> initializeRankMap() {
        Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);

        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }
        return rankResult;
    }
}
