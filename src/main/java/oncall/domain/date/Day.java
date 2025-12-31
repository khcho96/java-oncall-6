package oncall.domain.date;

import java.util.Objects;

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

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Day day1 = (Day) object;
        return day == day1.day;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(day);
    }
}
