package oncall.util;

import oncall.constant.ErrorMessage;

public final class Validator {

    private static final String WORKERS_FORMAT = "^[가-힣]+ *(, *[가-힣]+ *)*$";
    private static final String DATE_FORMAT = "^\\d+ *, *[가-힣]$";

    private Validator() {}

    public static void validateDateFormat(String readDate) {
        if (!readDate.matches(DATE_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getErrorMessage());
        }
    }

    public static void validateWorkersFormat(String workers) {
        if (!workers.matches(WORKERS_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getErrorMessage());
        }
    }
}
