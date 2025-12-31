package oncall.util;

import oncall.view.OutputView;

public final class Retry {

    private Retry() {}

    public static void retryUntilSuccess(Runnable action) {
        while (true) {
            try {
                action.run();
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }
}
