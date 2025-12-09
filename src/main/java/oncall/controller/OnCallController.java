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
        registerMonthAndDay();
        registerWeekdaysWorkers();
        registerWeekendsWorkers();
        OnCallResultDto result = getResult();
        OutputView.printResult(result);
    }

    private void registerMonthAndDay() {
        while (true) {
            try {
                String rawMonthAndDay = InputView.readMonthAndDay();
                List<String> monthAndDay = InputParser.parseMonthAndDay(rawMonthAndDay);
                onCallService.registerMonthAndDay(monthAndDay);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void registerWeekdaysWorkers() {
        while (true) {
            try {
                String rawWeekdaysWorkers = InputView.readWeekdaysWorkers();
                List<String> weekdaysWorkers = InputParser.parseWorkers(rawWeekdaysWorkers);
                onCallService.registerWeekdaysWorkers(weekdaysWorkers);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e);
            }
        }
    }

    private void registerWeekendsWorkers() {
        while (true) {
            try {
                String rawWeekendsWorkers = InputView.readWeekendsWorkers();
                List<String> weekendsWorkers = InputParser.parseWorkers(rawWeekendsWorkers);
                onCallService.registerWeekendsWorkers(weekendsWorkers);
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
