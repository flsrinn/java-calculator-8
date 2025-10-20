package calculator;

import calculator.service.StringCalculatorService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorServiceTest {

    private final StringCalculatorService calculatorService = new StringCalculatorService();

    @Test
    void 빈_문자열_입력_시_0_반환() {
        String input = "";
        int result = calculatorService.calculate(input);
        assertThat(result).isEqualTo(0);
    }
}
