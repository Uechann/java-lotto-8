package lotto.domain.result;

import lotto.domain.rule.LottoRankingCriteria;
import lotto.domain.rule.RankingCriteria;
import lotto.domain.rule.Rank;
import lotto.domain.rule.RuleTable;
import lotto.domain.rule.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingCriteriaTest {

    private final RankingCriteria rankingCriteria = new LottoRankingCriteria(
            List.of(new RuleTable((m, b) -> m == 6, Rank.FIRST),
                    new RuleTable((m, b) -> m == 5 && b, Rank.SECOND),
                    new RuleTable((m, b) -> m == 5, Rank.THIRD),
                    new RuleTable((m, b) -> m == 4, Rank.FOURTH),
                    new RuleTable((m, b) -> m == 3, Rank.FIFTH)));

    @Nested
    @DisplayName("로또 발행 번호 케이스마다 당첨 등수 판별이 잘 이루어지는지 테스트")
    class LottoRankingJudging {

        @Test
        void 일등_판별테스트() {
            assertThat(rankingCriteria.judge(MatchResult.of(6, false))).isEqualTo(Rank.FIRST);
        }

        @Test
        void 이등_판별테스트() {
            assertThat(rankingCriteria.judge(MatchResult.of(5, true))).isEqualTo(Rank.SECOND);
        }

        @Test
        void 삼등_판별테스트() {

            assertThat(rankingCriteria.judge(MatchResult.of(5, false))).isEqualTo(Rank.THIRD);
        }

        @Test
        void 사등_판별테스트() {


            assertThat(rankingCriteria.judge(MatchResult.of(4, false))).isEqualTo(Rank.FOURTH);
            assertThat(rankingCriteria.judge(MatchResult.of(4, true))).isEqualTo(Rank.FOURTH);
        }

        @Test
        void 오등_판별테스트() {
            assertThat(rankingCriteria.judge(MatchResult.of(3, false))).isEqualTo(Rank.FIFTH);
            assertThat(rankingCriteria.judge(MatchResult.of(3, true))).isEqualTo(Rank.FIFTH);
        }

        @Test
        void 등수이외_판별테스트() {
            assertThat(rankingCriteria.judge(MatchResult.of(2, false))).isEqualTo(Rank.NONE);
            assertThat(rankingCriteria.judge(MatchResult.of(2, true))).isEqualTo(Rank.NONE);
            assertThat(rankingCriteria.judge(MatchResult.of(1, false))).isEqualTo(Rank.NONE);
            assertThat(rankingCriteria.judge(MatchResult.of(1, true))).isEqualTo(Rank.NONE);
            assertThat(rankingCriteria.judge(MatchResult.of(0, false))).isEqualTo(Rank.NONE);
            assertThat(rankingCriteria.judge(MatchResult.of(0, true))).isEqualTo(Rank.NONE);
        }
    }
}
