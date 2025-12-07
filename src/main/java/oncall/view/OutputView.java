package oncall.view;

import java.util.List;
import oncall.domain.OnCallPerDay;
import oncall.dto.OnCallResultDto;

public class OutputView {

    public static void printResult(OnCallResultDto onCallResultDto) {
        List<OnCallPerDay> result = onCallResultDto.result();
        for (OnCallPerDay onCallPerDay : result) {
            System.out.println(onCallPerDay);
        }
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }
}
