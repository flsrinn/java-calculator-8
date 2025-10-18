package calculator.service;

import java.util.ArrayList;

public class StringCalculatorService {
    private final TokenSplitter splitter = new TokenSplitter();
    private final Adder adder = new Adder();

    public int calculate(String input) {
        ArrayList<String> tokens = splitter.split(input);
        return adder.sum(tokens);
    }
}
