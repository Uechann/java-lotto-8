package lotto.domain.result;

import java.util.Map;

public record RankResult(Map<Rank, Integer> rankStatistics) {
}
