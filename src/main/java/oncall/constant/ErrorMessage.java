package oncall.constant;

public enum ErrorMessage {

    INVALID_ERROR("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE_PREFIX + errorMessage;
    }
}
