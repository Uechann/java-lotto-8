package lotto.view;

import lotto.domain.rule.result.RankResult;

import java.util.List;

public class OutputView {

    private StringBuilder builder = new StringBuilder();

    public OutputView() {
    }

    // 구입한 로또 출력
    public void printPurchaseLottos(List<List<Integer>> numbers) {
        System.out.println("\n" + numbers.size() + "개를 구매했습니다.");

        numbers.forEach(number -> {
            System.out.println(number.toString());
        });
    }

    // 당첨 통계 출력
    public void printLottosStatistics(RankResult rankResult) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.print(rankResult.toString());
    }

    // 수익률 출력
    public void printYield(double yield) {
        System.out.println("총 수익률은 " + String.format("%,.1f", yield) + "%입니다.");
    }

    public void printErrorMessage(String s) {
        System.out.println(s);
    }
}
