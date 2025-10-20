package calculator.service;

import calculator.service.utils.Adder;
import calculator.service.utils.DelimiterParser;
import calculator.service.utils.TokenSplitter;

import java.util.ArrayList;

// 문자열 계산기 비즈니스 로직을 총괄하는 메인 서비스 클래스
public class StringCalculatorService {
    // 입력 문자열에서 커스텀 구분자와 숫자 본문을 추출하는 파서
    private final DelimiterParser parser;
    // 입력값과 토큰 유효성 검증
    private final InputValidator validator;
    // 사용자가 입력한 문자열을 구분자 기준으로 토큰으로 분리
    private final TokenSplitter splitter;
    // 숫자 토큰 리스트의 합계를 계산
    private final Adder adder;

    public StringCalculatorService() {
        this.parser = new DelimiterParser();
        this.splitter = new TokenSplitter();
        this.adder = new Adder();
    }

    // 사용자가 입력한 문자열을 받아 유효성 검증, 분리, 합산 과정을 거쳐 최종 결과를 반환
    public int calculate(String input) {
        // 1. 커스텀 구분자 선언부를 파싱하여 [식, 구분자] 추출
        String[] parsed = parser.parse(input);
        String body = parsed[0];
        String customDelimiter = parsed[1];

        // 2. 본문을 구분자 기준으로 토큰화하여 토큰 리스트 생성
        ArrayList<String> tokens = splitter.split(body, customDelimiter);

        // 3. 지정된 Operation을 적용해 최종 결과 반환
        return operation.apply(tokens);
    }
}
