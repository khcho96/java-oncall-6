package oncall.service;

import java.util.List;
import oncall.constant.Weeks;
import oncall.domain.OnCalls;
import oncall.domain.Workers;
import oncall.domain.date.Dates;
import oncall.util.InputParser;
import oncall.view.InputView;

public class OnCallService {

    private Workers workers;
    private Dates dates;

    public void registerWorkers(List<String> weekdaysWorkers) {
        workers = Workers.newInstance();
        workers.addWeekdaysWorkers(Weeks.WEEKDAYS, weekdaysWorkers);

        String readHolidays = InputView.readHolidays();
        List<String> holidaysWorkers = InputParser.parseWorkers(readHolidays);

        workers.addHolidaysWorkers(Weeks.HOLIDAYS, holidaysWorkers);
    }

    public void setDates(int month, String dayOfWeek) {
        dates = Dates.newInstance();
        dates.setInit(month, dayOfWeek);
    }

    public OnCalls getResult() {
        OnCalls onCalls = OnCalls.newInstance();
        onCalls.assignWorkers(dates, workers);
        return onCalls;
    }
}
