package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DatesTest {

    @ParameterizedTest
    @CsvSource(value = {"1,월,31,수","2,월,28,일", "4,일,30,월"})
    void 달력_생성_테스트(int month, String dayOfWeek, int lastDay, String dayOfWeekOfLastDay) {
        Dates dates = Dates.newInstance();
        dates.setInit(month, dayOfWeek);
        Date date = dates.getDates().get(dates.getDates().size() - 1);

        Month eMonth = Month.from(month);
        Day eDay = Day.from(lastDay);
        DayOfWeek eDayOfWeek = DayOfWeek.from(dayOfWeekOfLastDay);
        Date expectedDate = Date.of(eMonth,eDay, eDayOfWeek);

        assertThat(date).isEqualTo(expectedDate);
    }
}