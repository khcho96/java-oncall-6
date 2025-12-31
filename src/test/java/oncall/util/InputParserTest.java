package oncall.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputParserTest {

    @ParameterizedTest
    @ValueSource(strings = {" 1 ,월 ", " 1 ,월", "1,월 ", " 1,월 "})
    void 월_요일_입력값_파싱(String input) {
        assertThat(InputParser.parseDate(input)).containsExactly("1", "월");
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "2,2"})
    void 월_입력값_파싱(String input, int res) {
        assertThat(InputParser.parseMonth(input)).isEqualTo(res);
    }
}