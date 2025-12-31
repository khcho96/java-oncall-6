package oncall;

import java.util.List;
import oncall.domain.Dates;
import oncall.domain.Weeks;
import oncall.domain.Workers;
import oncall.util.InputParser;
import oncall.util.Retry;
import oncall.view.InputView;

public class Application {

    static Dates dates;
    static Workers workers;

    public static void main(String[] args) {
        setDate();

        Retry.retryUntilSuccess(() -> {
            // 평일
            String readWeekdays = InputView.readWeekdays();
            List<String> weekdaysWorkers = InputParser.parseWorkers(readWeekdays);

            workers = Workers.newInstance();
            workers.addWeekdaysWorkers(Weeks.WEEKDAYS, weekdaysWorkers);

            // 휴일
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
