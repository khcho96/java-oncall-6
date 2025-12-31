package oncall.view;

import oncall.domain.OnCall;
import oncall.domain.OnCalls;
import oncall.domain.Worker;
import oncall.domain.date.Date;

public class OutputView {

    private OutputView() {
    }

    public static void printResult(OnCalls onCalls) {
        System.out.println();
        for (OnCall onCall : onCalls.getOnCalls()) {
            Date date = onCall.getDate();
            Worker worker = onCall.getWorker();
            if (onCall.isBoth()) {
                System.out.printf("%s(휴일) %s\n", date, worker);
                continue;
            }
            System.out.printf("%s %s\n", date, worker);
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
