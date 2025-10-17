package calculator.controller;

import calculator.view.InputView;

// 프로그램의 전체 흐름을 제어하는 클래스
public class CalculatorController {
    private final InputView inputView; // 입력 담당 View

    public CalculatorController() {
        this.inputView = new InputView();
    }

    public void run() {
        String raw = inputView.readInput();
    }
}
