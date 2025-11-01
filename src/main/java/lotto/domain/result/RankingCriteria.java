package lotto.domain.result;

public interface RankingCriteria {
    Rank judge(int matchCount, boolean bonusMatch);
}
