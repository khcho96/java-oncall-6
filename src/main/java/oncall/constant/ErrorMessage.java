package oncall.constant;

public enum ErrorMessage {

    INVALID_FORMAT("잘못된 형식입니다."),
    INVALID_MONTH("잘못된 월입니다."),
    INVALID_DAY_OF_WEEK("잘못된 요일입니다.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
