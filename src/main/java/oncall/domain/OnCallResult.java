package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.constant.Constant;
import oncall.constant.HoliDays;

public class OnCallResult {

    private final List<OnCallPerDay> result;

    private OnCallResult() {
        this.result = new ArrayList<>();
    }

    public static OnCallResult newInstance() {
        return new OnCallResult();
    }

    public void addDayOfTheWeek(int month, int day, String dayOfTheWeek) {
        boolean isHoliDayOnWeekDays = false;
        if (HoliDays.isHoliday(month, day) && isWeekDays(dayOfTheWeek)) {
            isHoliDayOnWeekDays = true;
        }
        result.add(OnCallPerDay.of(month, day, dayOfTheWeek, isHoliDayOnWeekDays));
    }

    private boolean isWeekDays(String dayOfTheWeek) {
        return Constant.WEEKDAYS.contains(dayOfTheWeek);
    }

    public List<OnCallPerDay> getResult() {
        return result;
    }
}
