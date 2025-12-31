package oncall;

import java.util.List;
import oncall.domain.date.Dates;
import oncall.domain.OnCalls;
import oncall.constant.Weeks;
import oncall.domain.Workers;
import oncall.util.InputParser;
import oncall.util.Retry;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {

    static Dates dates;
    static Workers workers;

    public static void main(String[] args) {
        setDate();

        registerWorkers();

        OnCalls onCalls = OnCalls.newInstance();
        onCalls.assignWorkers(dates, workers);

        OutputView.printResult(onCalls);
    }

    private static void registerWorkers() {
        Retry.retryUntilSuccess(() -> {
            String readWeekdays = InputView.readWeekdays();
            List<String> weekdaysWorkers = InputParser.parseWorkers(readWeekdays);

            workers = Workers.newInstance();
            workers.addWeekdaysWorkers(Weeks.WEEKDAYS, weekdaysWorkers);

            String readHolidays = InputView.readHolidays();
            List<String> holidaysWorkers = InputParser.parseWorkers(readHolidays);

            workers.addHolidaysWorkers(Weeks.HOLIDAYS, holidaysWorkers);
        });
    }

    private static void setDate() {
        Retry.retryUntilSuccess(() -> {
            String readDate = InputView.readDate();
            List<String> date = InputParser.parseDate(readDate);
            int month = InputParser.parseMonth(date.get(0));
            String dayOfWeek = date.get(1);

            dates = Dates.newInstance();
            dates.setInit(month, dayOfWeek);
        });
    }
}
