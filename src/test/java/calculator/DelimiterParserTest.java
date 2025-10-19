package calculator;

import calculator.service.utils.DelimiterParser;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DelimiterParserTest {

    private final DelimiterParser parser = new DelimiterParser();

    @Test
    void 기본_구분자_테스트() {
        String[] res = parser.parse("1,2:3");
        assertThat(res[0]).isEqualTo("1,2:3");
        assertThat(res[1]).isNull();
    }

    @Test
    void 커스텀_구분자_형식_테스트() {
        String[] res = parser.parse("//;\n1;2;3");
        assertThat(res[0]).isEqualTo("1;2;3"); // body
        assertThat(res[1]).isEqualTo(";");     // delimiter
    }
}
