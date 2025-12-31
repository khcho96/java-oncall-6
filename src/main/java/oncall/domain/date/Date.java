package oncall.domain.date;

import oncall.constant.LegalHoliday;
import oncall.constant.Weeks;

public class Date {

    private final Month month;
    private final Day day;
    private final DayOfWeek dayOfWeek;

    private Date(Month month, Day day, DayOfWeek dayOfWeek) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
    }

    public static Date of(Month month, Day day, DayOfWeek dayOfWeek) {
        return new Date(month, day, dayOfWeek);
    }

    public Month getMonth() {
        return month;
    }

    public Day getDay() {
        return day;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public boolean isWeekdays() {
        return dayOfWeek.getWeeks().equals(Weeks.WEEKDAYS);
    }

    public boolean isHolidays() {
        return dayOfWeek.getWeeks().equals(Weeks.HOLIDAYS);
    }

    public boolean isBoth() {
        return dayOfWeek.getWeeks().equals(Weeks.WEEKDAYS) && isLegalHolidays();
    }

    private boolean isLegalHolidays() {
        return !LegalHoliday.of(month.getMonth(), day.getDay()).equals(LegalHoliday.NONE);
    }
}
