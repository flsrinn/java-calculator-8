package calculator.view;

import camp.nextstep.edu.missionutils.Console;

// 사용자의 입력을 담당하는 클래스
public class InputView {

    // 사용자로부터 문자열을 입력 받고, CalculatorController에 전달함
    public String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}
