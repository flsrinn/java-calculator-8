package calculator.service;

import java.util.ArrayList;

// 문자열 계산기 비즈니스 로직을 총괄하는 메인 서비스 클래스
public class StringCalculatorService {
    // 입력값과 토큰 유효성 검증
    private final InputValidator validator = new InputValidator();
    // 사용자가 입력한 문자열을 구분자 기준으로 토큰으로 분리
    private final TokenSplitter splitter = new TokenSplitter();
    // 숫자 토큰 리스트의 합계를 계산
    private final Adder adder = new Adder();

    // 사용자가 입력한 문자열을 받아 유효성 검증, 분리, 합산 과정을 거쳐 최종 결과를 반환
    public int calculate(String input) {
        validator.validateCustomHeaderFormat(input);
        ArrayList<String> tokens = splitter.split(input);
        validator.validateTokens(tokens);

        return adder.sum(tokens);
    }
}
