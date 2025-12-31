package oncall.domain.date;

import java.util.Arrays;
import oncall.constant.ErrorMessage;

public enum Month {

    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31),
    ;

    private final int month;
    private final int dayOfEnd;

    Month(int month, int dayOfEnd) {
        this.month = month;
        this.dayOfEnd = dayOfEnd;
    }

    public static Month from(int m) {
        return Arrays.stream(values())
                .filter(month -> month.month == m)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_MONTH.getErrorMessage()));
    }

    public int getMonth() {
        return month;
    }

    public int getDayOfEnd() {
        return dayOfEnd;
    }
}
