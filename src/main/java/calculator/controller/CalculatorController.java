package calculator.controller;

import calculator.service.StringCalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

// 프로그램의 전체 흐름을 제어하는 클래스
public class CalculatorController {
    private final InputView inputView; // 입력 담당 View
    private final OutputView outputView; // 출력 담당 View
    private final StringCalculatorService stringCalculatorService;

    public CalculatorController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stringCalculatorService = new StringCalculatorService();
    }

    public void run() {
        String raw = inputView.readInput();
        int result = stringCalculatorService.calculate(raw);
        outputView.printResult(result);
    }
}
