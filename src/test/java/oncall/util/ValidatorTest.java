package oncall.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1 월", "월,1"})
    void 월_요일_입력_오류(String input) {
        assertThatThrownBy(() -> Validator.validateDateFormat(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.INVALID_FORMAT.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"가나 다라 마바 사아 자차", "가나-다라-마바-사아"})
    void 근무자_입력_오류(String input) {
        assertThatThrownBy(() -> Validator.validateWorkersFormat(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_FORMAT.getErrorMessage());
    }
}