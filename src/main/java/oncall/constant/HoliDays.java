package oncall.constant;

public enum HoliDays {
    NEW_YEAR_DAY(1,1),
    MANSE_DAY(3,1),
    CHILDREN_DAY(5,5),
    MEMORIAL_DAY(6,6),
    LIBERATION_DAY(8,15),
    NATIONAL_FOUNDATION_DAY(10,3),
    HANGUL_DAY(10,9),
    CHRISTMAS(12,25);

    private final int month;
    private final int day;

    HoliDays(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        HoliDays[] holiDays = HoliDays.values();
        for (HoliDays holiDay : holiDays) {
            if (month == holiDay.month && day == holiDay.day) {
                return true;
            }
        }
        return false;
    }
}
