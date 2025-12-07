package oncall.constant;

import java.util.List;
import java.util.Map;

public final class Constant {

    public static final Map<Integer, Integer> COUNT_OF_DAYS_IN_MONTH = Map.ofEntries(
            Map.entry(1, 31),
            Map.entry(2, 28),
            Map.entry(3, 31),
            Map.entry(4, 30),
            Map.entry(5, 31),
            Map.entry(6, 30),
            Map.entry(7, 31),
            Map.entry(8, 31),
            Map.entry(9, 30),
            Map.entry(10, 31),
            Map.entry(11, 30),
            Map.entry(12, 31)
    );
    public static final List<String> DAYS_OF_THE_WEEK = List.of("월", "화", "수", "목", "금", "토", "일");
    public static final List<String> WEEKDAYS = List.of("월", "화", "수", "목", "금");
    public static final List<String> WEEKENDS = List.of("토", "일");
}
