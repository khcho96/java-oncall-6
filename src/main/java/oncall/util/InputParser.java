package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class InputParser {

    private static final String DELIMITER = ",";

    private InputParser() {
    }

    public static List<String> parseDate(String readDate) {
        readDate = readDate.strip();

        Validator.validateDateFormat(readDate);

        String[] splitDate = readDate.split(DELIMITER);

        return Arrays.stream(splitDate)
                .map(String::strip)
                .toList();
    }

    public static int parseMonth(String date) {
        return NumberConvertor.convertToNumber(date);
    }

    public static List<String> parseWorkers(String readWorkers) {
        readWorkers = readWorkers.strip();

        Validator.validateWorkersFormat(readWorkers);

        List<String> workers = new ArrayList<>();
        for (String worker : readWorkers.split(DELIMITER)) {
            workers.add(worker.strip());
        }

        return workers;
    }
}
