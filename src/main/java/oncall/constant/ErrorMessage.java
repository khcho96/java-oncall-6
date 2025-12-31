package oncall.constant;

public enum ErrorMessage {

    INVALID_FORMAT("잘못된 형식입니다."),
    INVALID_MONTH("잘못된 월입니다."),
    INVALID_DAY_OF_WEEK("잘못된 요일입니다."),

    NAME_UNIQUE_ERROR("이름이 중복입니다."),
    NAME_COUNT_ERROR("인원은 5명 이상 35명 이하로 입력해야 합니다."),
    NAME_LENGTH_ERROR("이름은 1자 이상 5자 이하로 입력해야 합니다."),
    WORKERS_NAMES_DIFFERENCE_ERROR("평일 비상 근무자 목록과 다릅니다."),
    ;

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return ERROR_MESSAGE_PREFIX + String.format(errorMessage, args);
    }
}
