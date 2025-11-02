package lotto.global.util;

import lotto.view.OutputView;

import java.util.function.Function;
import java.util.function.Supplier;

public final class Retry {

    private Retry() {
    }

    public static <T> String askUntilValid(OutputView out, Supplier<T> supplier, Function<String, T> validator) {
        while (true) {
            try {
                String data = supplier.get().toString();
                validator.apply(data);
                return data;
            } catch (IllegalArgumentException exception) {
                out.printErrorMessage("[ERROR] " + exception.getMessage());
            }
        }
    }
}
