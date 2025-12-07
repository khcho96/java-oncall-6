package oncall.util;

import static oncall.constant.ErrorMessage.INVALID_ERROR;

import java.util.List;
import oncall.constant.Constant;

public final class Validator {

    private static final String MONTH_DAY_FORMAT = "^ *\\d+ *, *[가-힣]+ *$";
    private static final String WORKERS_FORMAT = "^ *[가-힣a-zA-Z]+ *(, *[가-힣a-zA-Z]+ *)*$";

    private Validator() {}

    public static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

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

    public static void validateWorkersFormat(String rawInput) {
        if (!rawInput.matches(WORKERS_FORMAT)) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateWorkersNameLength(List<String> workers) {
        for (String worker : workers) {
            if (worker.isEmpty() || worker.length() > 5) {
                throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
            }
        }
    }

    public static void validateWorkersCount(List<String> workers) {
        if (workers.size() < 5 || workers.size() > 35) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }

    public static void validateWorkersUnique(List<String> workers) {
        if (workers.stream().distinct().count() != workers.size()) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }
}
