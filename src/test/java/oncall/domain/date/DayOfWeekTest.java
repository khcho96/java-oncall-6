package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import oncall.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DayOfWeekTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "나"})
    void 오류_테스트_템플릿(String input) {
        assertThatThrownBy(() -> DayOfWeek.from(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_DAY_OF_WEEK.getErrorMessage());
    }

    @Test
    void 정상_작동_테스트_템플릿() {
        DayOfWeek dayOfWeek = DayOfWeek.from("월");
        assertThat(dayOfWeek).isEqualTo(DayOfWeek.MON);
    }
}