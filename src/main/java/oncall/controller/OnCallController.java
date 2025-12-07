package oncall.controller;

import java.util.List;
import oncall.dto.OnCallResultDto;
import oncall.service.OnCallService;
import oncall.util.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final OnCallService onCallService;

    public OnCallController(OnCallService onCallService) {
        this.onCallService = onCallService;
    }

    public void run() {
        method1();
        method2();
        method3();
        OnCallResultDto result = getResult();
        OutputView.printResult(result);
    }

    private void method1() {
        while (true) {
            try {
                String rawMonthAndDay = InputView.readMonthAndDay();
                List<String> monthAndDay = InputParser.parseMonthAndDay(rawMonthAndDay);
                onCallService.method1(monthAndDay);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void method2() {
        while (true) {
            try {
                String rawWeekdaysWorkers = InputView.readWeekdaysWorkers();
                List<String> weekdaysWorkers = InputParser.parseWorkers(rawWeekdaysWorkers);
                onCallService.method2(weekdaysWorkers);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void method3() {
        while (true) {
            try {
                String rawWeekendsWorkers = InputView.readWeekendsWorkers();
                List<String> weekendsWorkers = InputParser.parseWorkers(rawWeekendsWorkers);
                onCallService.method3(weekendsWorkers);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private OnCallResultDto getResult() {
        return onCallService.getResult();
    }
}
