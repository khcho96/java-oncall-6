package oncall.service;

import static oncall.constant.Constant.COUNT_OF_DAYS_IN_MONTH;

import java.util.List;
import oncall.constant.Constant;
import oncall.domain.OnCallResult;
import oncall.domain.Workers;
import oncall.dto.OnCallResultDto;
import oncall.util.NumberConvertor;

public class OnCallService {

    private OnCallResult onCallResult;
    private Workers workers;

    public OnCallService() {};

    public void method1(List<String> monthAndDay) {
        int month = NumberConvertor.convertToNumber(monthAndDay.get(0));
        String dayOfTheWeek = monthAndDay.get(1);
        int dayIndex = Constant.DAYS_OF_THE_WEEK.indexOf(dayOfTheWeek);

        onCallResult = OnCallResult.newInstance();

        for (int day = 1; day <= COUNT_OF_DAYS_IN_MONTH.get(month); day++) {
            onCallResult.addDayOfTheWeek(month, day, Constant.DAYS_OF_THE_WEEK.get(dayIndex));

            if (dayIndex == 6) {
                dayIndex = 0;
                continue;
            }

            dayIndex++;
        }
    }

    public void method2(List<String> weekdaysWorkers) {
        workers = Workers.newInstance();
        workers.registerWeekdaysWorkers(weekdaysWorkers);
    }

    public void method3(List<String> weekendsWorkers) {
        workers.validateMatchWeekdaysAnd(weekendsWorkers);
        workers.registerWeekendsWorkers(weekendsWorkers);
    }

    public OnCallResultDto getResult() {
        onCallResult.assignWorkers(workers);

        return new OnCallResultDto(onCallResult.getResult());
    }
}
