package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {
    }

    public String InputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String InputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String InputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
