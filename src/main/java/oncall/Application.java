package oncall;

import java.util.List;
import oncall.util.InputParser;
import oncall.view.InputView;

public class Application {
    public static void main(String[] args) {

        String rawMonthAndDay = InputView.readMonthAndDay();
        List<String> monthAndDay = InputParser.parseMonthAndDay(rawMonthAndDay);


    }
}
