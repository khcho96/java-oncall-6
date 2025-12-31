package oncall.domain.date;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dates {

    private List<Date> dates;

    private Dates() {
        dates = new ArrayList<>();
    }

    public static Dates newInstance() {
        return new Dates();
    }

    public void setInit(int m, String dow) {
        Month month = Month.from(m);
        DayOfWeek startDayOfWeek = DayOfWeek.from(dow);

        List<DayOfWeek> dayOfWeeks = Arrays.stream(DayOfWeek.values()).toList();
        int index = dayOfWeeks.indexOf(startDayOfWeek);

        for (int d = 1; d <= month.getDayOfEnd(); d++) {
            Day day = Day.from(d);
            DayOfWeek dayOfWeek = dayOfWeeks.get(index % 7);

            dates.add(Date.of(month, day, dayOfWeek));

            index++;
        }
    }

    public List<Date> getDates() {
        return dates;
    }
}
