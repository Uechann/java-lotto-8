package lotto.domain.result;

public class LottoRankingCriteria implements RankingCriteria {

    @Override
    public Rank judge(int matchCount, boolean bonusMatch) {
        return Rank.judgeRank(matchCount, bonusMatch);
    }
}
