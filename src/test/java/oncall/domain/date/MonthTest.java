package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import oncall.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MonthTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "13"})
    void 오류_테스트_템플릿(int input) {
        assertThatThrownBy(() -> Month.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_MONTH.getErrorMessage());
    }

    @Test
    void 정상_작동_테스트_템플릿() {
        Month month = Month.from(12);
        assertThat(month).isEqualTo(Month.DEC);
    }
}