package calculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

// 주어진 문자열을 구분자 기준으로 분리하여 토큰 리스트를 생성
public class TokenSplitter {

    // 기본 구분자
    private static final Pattern DEFAULT_DELIMS = Pattern.compile("[,:]");

    // 입력된 문자열을 구분자 기준으로 분리하여 문자열 리스트로 반환하는 함수
    public ArrayList<String> split(String body, String customDelimiter) {
        String[] parts;
        if(customDelimiter == null) {
            // 커스텀 구분자가 없으면 기본 구분자로 분리
            parts = DEFAULT_DELIMS.split(body, -1);
        } else {
            // 커스텀 구분자가 있으면 해당 구분자로 분리
            // Pattern.quote는 구분자 자체를 문자로 처리하기 위해 사용
            Pattern customPattern = Pattern.compile(Pattern.quote(customDelimiter));
            parts = customPattern.split(body, -1);
        }

        // 분리된 문자열 배열을 ArrayList로 변환하여 반환
        ArrayList<String> tokens = new ArrayList<>();
        Collections.addAll(tokens, parts);
        return tokens;
    }
}
