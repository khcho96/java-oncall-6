package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constant.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WorkerTest {

    @ParameterizedTest
    @ValueSource(strings = {"가나다라마바"})
    void 이름_길이_오류(String input) {
        assertThatThrownBy(() -> Worker.from(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NAME_LENGTH_ERROR.getErrorMessage());
    }
}