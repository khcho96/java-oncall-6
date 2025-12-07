package oncall.domain;

public class OnCallPerDay {

    private final int month;
    private final int day;
    private final String dayOfTheWeek;
    private final boolean isHoliDayOnWeekDays;
//    private final String worker;

    private OnCallPerDay(int month, int day, String dayOfTheWeek, boolean isHoliDayOnWeekDays) {
        this.month = month;
        this.day = day;
        this.dayOfTheWeek = dayOfTheWeek;
        this.isHoliDayOnWeekDays = isHoliDayOnWeekDays;
    }

    public static OnCallPerDay of(int month, int day, String dayOfTheWeek, boolean isHoliDayOnWeekDays) {
        return new OnCallPerDay(month, day, dayOfTheWeek, isHoliDayOnWeekDays);
    }

    @Override
    public String toString() {
        return month + "월 " + day + "일 " + dayOfTheWeek + "(" + isHoliDayOnWeekDays + ") " + "이름";
    }
}
