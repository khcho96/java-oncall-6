package oncall;

import static oncall.constant.Constant.COUNT_OF_DAYS_IN_MONTH;

import java.util.List;
import oncall.constant.Constant;
import oncall.domain.OnCallPerDay;
import oncall.domain.OnCallResult;
import oncall.domain.Workers;
import oncall.util.InputParser;
import oncall.util.NumberConvertor;
import oncall.view.InputView;

public class Application {
    public static void main(String[] args) {

        String rawMonthAndDay = InputView.readMonthAndDay();
        List<String> monthAndDay = InputParser.parseMonthAndDay(rawMonthAndDay);

        int month = NumberConvertor.convertToNumber(monthAndDay.get(0));
        String dayOfTheWeek = monthAndDay.get(1);
        int dayIndex = Constant.DAYS_OF_THE_WEEK.indexOf(dayOfTheWeek);

        OnCallResult onCallResult = OnCallResult.newInstance();

        for (int day = 1; day <= COUNT_OF_DAYS_IN_MONTH.get(month); day++) {
            onCallResult.addDayOfTheWeek(month, day, Constant.DAYS_OF_THE_WEEK.get(dayIndex));

            if (dayIndex == 6) {
                dayIndex = 0;
                continue;
            }

            dayIndex++;
        }

        String rawWeekdaysWorkers = InputView.readWeekdaysWorkers();
        List<String> weekdaysWorkers = InputParser.parseWorkers(rawWeekdaysWorkers);

        Workers workers = Workers.newInstance();
        workers.registerWeekdaysWorkers(weekdaysWorkers);

        String rawWeekendsWorkers = InputView.readWeekendsWorkers();
        List<String> weekendsWorkers = InputParser.parseWorkers(rawWeekendsWorkers);

        workers.validateMatchWeekdaysAnd(weekendsWorkers);
        workers.registerWeekendsWorkers(weekendsWorkers);

        onCallResult.assignWorkers(workers);

//        List<OnCallPerDay> result = onCallResult.getResult();
//        for (OnCallPerDay onCallPerDay : result) {
//            System.out.println(onCallPerDay);
//        }
    }
}
