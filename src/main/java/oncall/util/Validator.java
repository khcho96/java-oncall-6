package oncall.util;

import static oncall.constant.ErrorMessage.INVALID_ERROR;

import oncall.constant.Constant;

public final class Validator {

    private static final String MONTH_DAY_FORMAT = "^ *\\d+ *, *[가-힣]+ *$";

    private Validator() {}

    public static void validateMonthAndDayFormat(String rawInput) {
        if (!rawInput.matches(MONTH_DAY_FORMAT)) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateDay(String day) {
        if (!Constant.DAYS_OF_THE_WEEK.contains(day)) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }
}
