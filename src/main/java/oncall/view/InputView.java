package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MONTH_DAY_REQUEST = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String WEEKDAYS_WORKERS_REQUEST = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String WEEKENDS_WORKERS_REQUEST = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public static String readMonthAndDay() {
        System.out.print(MONTH_DAY_REQUEST);
        return Console.readLine();
    }

    public static String readWeekdaysWorkers() {
        System.out.print(WEEKDAYS_WORKERS_REQUEST);
        return Console.readLine();
    }

    public static String readWeekendsWorkers() {
        System.out.print(WEEKENDS_WORKERS_REQUEST);
        return Console.readLine();
    }
}
