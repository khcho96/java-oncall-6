package oncall.domain;

public class Day {

    private final int day;

    private Day(int day) {
        this.day = day;
    }

    public static Day from(int day) {
        return new Day(day);
    }

    public int getDay() {
        return day;
    }
}
