package oncall.domain;

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
}
