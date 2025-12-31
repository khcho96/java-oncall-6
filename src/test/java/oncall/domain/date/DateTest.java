package oncall.domain.date;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DateTest {

    @Test
    void 평일_테스트() {
        Month month = Month.from(12);
        Day day = Day.from(20);
        DayOfWeek dayOfWeek = DayOfWeek.from("수");

        Date date = Date.of(month, day, dayOfWeek);

        assertThat(date.isWeekdays()).isTrue();
    }

    @Test
    void 휴일_테스트() {
        Month month = Month.from(12);
        Day day = Day.from(24);
        DayOfWeek dayOfWeek = DayOfWeek.from("일");

        Date date = Date.of(month, day, dayOfWeek);

        assertThat(date.isHolidays()).isTrue();
    }

    @Test
    void 평일이면서_법정공휴일_테스트() {
        Month month = Month.from(12);
        Day day = Day.from(25);
        DayOfWeek dayOfWeek = DayOfWeek.from("수");

        Date date = Date.of(month, day, dayOfWeek);

        assertThat(date.isBoth()).isTrue();
    }
}