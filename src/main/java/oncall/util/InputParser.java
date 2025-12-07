package oncall.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {}

    public static List<String> parseMonthAndDay(String rawInput) {
        Validator.validateNullOrBlank(rawInput);
        rawInput = rawInput.strip();

        Validator.validateMonthAndDayFormat(rawInput);

        List<String> monthAndDay = Stream.of(rawInput.strip().split(DELIMITER))
                .map(String::strip)
                .toList();

        Integer month = NumberConvertor.convertToNumber(monthAndDay.get(0));
        Validator.validateMonth(month);

        String day = monthAndDay.get(1);
        Validator.validateDay(day);

        return monthAndDay;
    }

//    public static List<String> parseWorkers(String rawInput) {
//        Validator.validateNullOrBlank(rawInput);
//        rawInput = rawInput.strip();
//
//        Validator.validateCsvFormat(rawInput);
//
//        return Stream.of(rawInput.split(DELIMITER))
//                .map(String::strip)
//                .map(NumberConvertor::convertToNumber)
//                .toList();
//    }
}
