package oncall.util;

import oncall.constant.ErrorMessage;

public final class Validator {

    private static final String NUMBER_FORMAT = "\\d+";
    private static final String TIME_FORMAT = "([01]\\d|2[0-3]):[0-5]\\d";
    private static final String DATE_RANGE = "^([1-9])|([1-2]\\d)|(3[0-1])$";
    private static final String _FORMAT = "^([가-힣]+-[1-9]\\d*) *(, *([가-힣]+-[1-9]\\d*) *)*$";
    private static final String DATE_FORMAT = "^\\d+ *, *[가-힣]$";

    private Validator() {}

    public static void validateXxx(String input) {
        input = input.strip();
    }

    public static void validateCsvFormat(String input) {
        input = input.strip();
    }

    public static void validateDateFormat(String readDate) {
        if (!readDate.matches(DATE_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getErrorMessage());
        }
    }
}
