package oncall.util;

import static oncall.constant.ErrorMessage.INVALID_ERROR;

public final class NumberConvertor {

    public static Integer convertToNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ERROR.getErrorMessage());
        }
    }
}
