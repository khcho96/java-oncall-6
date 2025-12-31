package oncall.domain;

import java.util.Arrays;
import oncall.constant.ErrorMessage;

public enum DayOfWeek {

    MON("월", Weeks.WEEKDAYS),
    TUE("화", Weeks.WEEKDAYS),
    WED("수", Weeks.WEEKDAYS),
    THU("목", Weeks.WEEKDAYS),
    FRI("금", Weeks.WEEKDAYS),
    SAT("토", Weeks.WEEKENDS),
    SUN("일", Weeks.WEEKENDS),
    ;

    private final String dayOfWeek;
    private final Weeks weeks;

    DayOfWeek(String dayOfWeek, Weeks weeks) {
        this.dayOfWeek = dayOfWeek;
        this.weeks = weeks;
    }

    public static DayOfWeek from(String dow) {
        return Arrays.stream(values())
                .filter(dayOfWeek -> dayOfWeek.dayOfWeek.equals(dow))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_DAY_OF_WEEK.getErrorMessage()));
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public Weeks getWeeks() {
        return weeks;
    }
}
