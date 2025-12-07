package oncall.domain;

import oncall.constant.Constant;

public class OnCallPerDay {

    private final int month;
    private final int day;
    private final String dayOfTheWeek;
    private final boolean isHoliDayOnWeekDays;
    private String worker;

    private OnCallPerDay(int month, int day, String dayOfTheWeek, boolean isHoliDayOnWeekDays) {
        this.month = month;
        this.day = day;
        this.dayOfTheWeek = dayOfTheWeek;
        this.isHoliDayOnWeekDays = isHoliDayOnWeekDays;
    }

    public static OnCallPerDay of(int month, int day, String dayOfTheWeek, boolean isHoliDayOnWeekDays) {
        return new OnCallPerDay(month, day, dayOfTheWeek, isHoliDayOnWeekDays);
    }

    public boolean isWeekdays() {
        return Constant.WEEKDAYS.contains(dayOfTheWeek) && !isHoliDayOnWeekDays;
    }

    public void assignWorker(String nextWorker) {
        worker = nextWorker;
    }

    @Override
    public String toString() {
        String holiDay = "";
        if (isHoliDayOnWeekDays) {
            holiDay = "(휴일)";
        }
        return month + "월 " + day + "일 " + dayOfTheWeek + holiDay + " " + worker;
    }
}
