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
}
