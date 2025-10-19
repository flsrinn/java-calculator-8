package calculator.service;

import calculator.service.utils.Adder;
import calculator.service.utils.DelimiterParser;
import calculator.service.utils.InputValidator;
import calculator.service.utils.TokenSplitter;

import java.util.ArrayList;

// 문자열 계산기 비즈니스 로직을 총괄하는 메인 서비스 클래스
public class StringCalculatorService {
    private final DelimiterParser parser;
    // 입력값과 토큰 유효성 검증
    private final InputValidator validator;
    // 사용자가 입력한 문자열을 구분자 기준으로 토큰으로 분리
    private final TokenSplitter splitter;
    // 숫자 토큰 리스트의 합계를 계산
    private final Adder adder;

    public StringCalculatorService() {
        this.parser = new DelimiterParser();
        this.validator = new InputValidator();
        this.splitter = new TokenSplitter();
        this.adder = new Adder();
    }

    // 사용자가 입력한 문자열을 받아 유효성 검증, 분리, 합산 과정을 거쳐 최종 결과를 반환
    public int calculate(String input) {
        // 1. 커스텀 구분자 선언부 형식 검증
        validator.validateCustomHeaderFormat(input);

        // 2. 구분자와 숫자 부분 분리
        String[] parsed = parser.parse(input);
        String body = parsed[0];
        String customDelimiter = parsed[1];

        // 3. 분리된 숫자 부분을 구분자 기준으로 토큰화
        ArrayList<String> tokens = splitter.split(body, customDelimiter);

        // 4. 분리된 각 토큰의 유효성 검증
        validator.validateTokens(tokens);

        // 5. 유효성 검증이 끝난 토큰들의 합계 계산
        return adder.sum(tokens);
    }
}
