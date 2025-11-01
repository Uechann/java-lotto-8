package lotto.domain.result;

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
                    Rank rank = entry.getKey();
                    Integer value = entry.getValue();
                    return rank.toString() + " - " + value + "개\n";
                })
                .collect(Collectors.joining());
    }

    // 총 당첨금 조회
    public int getTotalPrize() {
        int total = 0;
        for (Map.Entry<Rank, Integer> entry : rankStatistics.entrySet()) {
            Long prize = entry.getKey().getPrize();
            int value = entry.getValue();

            total += (prize * value);
        }
        return total;
    }
}
