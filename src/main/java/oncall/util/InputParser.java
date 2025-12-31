package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public final class InputParser {

    private static final String DELIMITER = ",";
    private static final String FIRST_DELIMITER = ",";
    private static final String SECOND_DELIMITER = "-";

    private InputParser() {
    }

    public static Integer parseToInteger(String rawInput) {
        rawInput = rawInput.strip();

        return NumberConvertor.convertToNumber(rawInput);
    }

    public static List<Integer> parseToElements1(String rawInput) {
        rawInput = rawInput.strip();

        Validator.validateCsvFormat(rawInput);

        return Stream.of(rawInput.split(DELIMITER))
                .map(String::strip)
                .map(NumberConvertor::convertToNumber)
                .toList();
    }

    public static List<String> parseToElements2(String rawInput) {
        rawInput = rawInput.strip();

        List<String> list = new ArrayList<>();
        String[] split = rawInput.split(FIRST_DELIMITER);
        for (String s : split) {
            String[] split1 = s.strip().split(SECOND_DELIMITER);

        }

        return list;
    }

    public static List<String> parseDate(String readDate) {
        readDate = readDate.strip();

        Validator.validateDateFormat(readDate);

        String[] splitDate = readDate.split(",");

        return Arrays.stream(splitDate)
                .map(String::strip)
                .toList();
    }

    public static int parseMonth(String date) {
        return NumberConvertor.convertToNumber(date);
    }

    public static List<String> parseWeekDays(String readWeekDays) {
        readWeekDays = readWeekDays.strip();

        Validator.validate
    }
}
