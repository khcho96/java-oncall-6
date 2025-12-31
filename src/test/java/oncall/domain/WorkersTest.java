package oncall.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import oncall.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WorkersTest {

    @Test
    void 근무자_이름_중복_오류() {
        Workers workers = Workers.newInstance();
        assertThatThrownBy(
                () -> workers.addWeekdaysWorkers(List.of("가나", "가나", "다라", "마바", "사아", "자차")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_UNIQUE_ERROR.getErrorMessage());
    }

    @ParameterizedTest
    @MethodSource("countErrorProvider")
    void 근무자_이름_개수_오류(List<String> input) {
        Workers workers = Workers.newInstance();
        assertThatThrownBy(() -> workers.addWeekdaysWorkers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NAME_COUNT_ERROR.getErrorMessage());
    }

    static Stream<Arguments> countErrorProvider() {
        return Stream.of(
                Arguments.of(List.of("가나", "다라", "마바", "사아")),
                Arguments.of(Arrays.stream("가갸거겨고교구규그기나냐너녀노뇨누뉴느니다댜더뎌도됴두듀드디라랴러려로료루류르리마먀머며모묘무뮤므미".split("")).toList())
        );
    }

    @Test
    void 평일_근무자와_휴일_근무자_이름_불일치_오류() {
        Workers workers = Workers.newInstance();
        workers.addWeekdaysWorkers(List.of("가나", "다라", "마바", "사아", "자차"));
        assertThatThrownBy(() -> workers.addHolidaysWorkers(List.of("가나", "다라", "마바", "제이콥", "자차")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.WORKERS_NAMES_DIFFERENCE_ERROR.getErrorMessage());
    }
}