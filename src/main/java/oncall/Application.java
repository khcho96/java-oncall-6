package oncall;

import java.util.List;
import oncall.domain.Dates;
import oncall.util.InputParser;
import oncall.util.Retry;
import oncall.view.InputView;

public class Application {

    static Dates dates;

    public static void main(String[] args) {
        setDate();

        Retry.retryUntilSuccess(() -> {
            String readWeekDays = InputView.readWeekDays();
            InputParser.parseWeekDays(readWeekDays);
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
