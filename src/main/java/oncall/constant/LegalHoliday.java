package oncall.constant;

import java.util.Arrays;

public enum LegalHoliday {

    NEW_DAY(1,1),
    MARCH_FIRST(3,1),
    CHILDREN(5,5),
    MEMORIAL(6,6),
    LIBERATION(8,15),
    FOUNDATION(10,3),
    KOREAN(10,9),
    CHRISTMAS(12,25),
    NONE(0,0)
    ;

    private final int month;
    private final int day;

    LegalHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static LegalHoliday of(int month, int day) {
        return Arrays.stream(values())
                .filter(legalHoliday -> legalHoliday.month == month && legalHoliday.day == day)
                .findFirst()
                .orElse(NONE);
    }
}
