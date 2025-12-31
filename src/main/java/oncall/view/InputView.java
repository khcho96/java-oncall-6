package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String _REQUEST = "";

    public static String read() {
        System.out.println(_REQUEST);
        return Console.readLine();
    }

    public static String readDate() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public static String readWeekdays() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

    public static String readHolidays() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }
}
