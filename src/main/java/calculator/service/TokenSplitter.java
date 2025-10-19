package calculator.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

// 주어진 문자열을 구분자 기준으로 분리하여 토큰 리스트를 생성
public class TokenSplitter {

    // 기본 구분자
    private static final Pattern DEFAULT_DELIMS = Pattern.compile("[,:]");
    // 구분자 파싱을 위한 DelimiterParser 인스턴스
    private final DelimiterParser delimiterParser = new DelimiterParser();

    // 입력된 문자열을 구분자 기준으로 분리하여 문자열 리스트로 반환하는 함수
    public ArrayList<String> split(String input) {
        // 커스텀 구분자와 계산식을 분리
        String[] parsed = delimiterParser.parse(input);
        String body = parsed[0];
        String custom = parsed[1];

        String[] parts;
        if(custom == null) {
            // 커스텀 구분자가 없으면 기본 구분자로 분리
            parts = DEFAULT_DELIMS.split(body, -1);
        } else {
            // 커스텀 구분자가 있으면 해당 구분자로 분리
            Pattern customPattern = Pattern.compile(Pattern.quote(custom));
            parts = customPattern.split(body, -1);
        }

        // 분리된 문자열 배열을 ArrayList로 변환하여 반환
        ArrayList<String> tokens = new ArrayList<>();
        Collections.addAll(tokens, parts);
        return tokens;
    }
}
