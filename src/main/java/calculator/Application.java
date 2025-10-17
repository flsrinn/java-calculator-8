package calculator;

import calculator.controller.CalculatorController;

public class Application {
    public static void main(String[] args) {
        CalculatorController calcController = new CalculatorController();
        calcController.run(); // 덧셈 계산기 실행
    }
}
