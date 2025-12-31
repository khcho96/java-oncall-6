package oncall.controller;

import java.util.List;
import oncall.domain.OnCalls;
import oncall.service.OnCallService;
import oncall.util.InputParser;
import oncall.util.Retry;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final OnCallService onCallService;

    public OnCallController(OnCallService onCallService) {
        this.onCallService = onCallService;
    }

    public void run() {
        setDate();

        registerWorkers();

        OnCalls result = onCallService.getResult();

        OutputView.printResult(result);
    }

    private void registerWorkers() {
        Retry.retryUntilSuccess(() -> {
            String readWeekdays = InputView.readWeekdays();
            List<String> weekdaysWorkers = InputParser.parseWorkers(readWeekdays);

           onCallService.registerWorkers(weekdaysWorkers);
        });
    }

    private void setDate() {
        Retry.retryUntilSuccess(() -> {
            String readDate = InputView.readDate();
            List<String> date = InputParser.parseDate(readDate);
            int month = InputParser.parseMonth(date.get(0));
            String dayOfWeek = date.get(1);

            onCallService.setDates(month, dayOfWeek);
        });
    }
}

