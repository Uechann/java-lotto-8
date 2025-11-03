package lotto.domain.rule.result;

import lotto.domain.rule.Rank;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public record RankResult(Map<Rank, Integer> rankStatistics) {

    @Override
    public String toString() {
        return rankStatistics.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.NONE)
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .map(entry -> {
                    return entry.getKey().toString() + " - " + entry.getValue() + "개\n";
                })
                .collect(Collectors.joining());
    }

    // 총 당첨금 조회
    public int getTotalPrize() {
        int total = 0;
        for (Map.Entry<Rank, Integer> entry : rankStatistics.entrySet()) {
            int prize = entry.getKey().getPrize();
            int value = entry.getValue();

            total += (prize * value);
        }
        return total;
    }
}
