package calculator.service.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

// 주어진 문자열을 구분자 기준으로 분리하여 토큰 리스트를 생성
public class TokenSplitter {

    // 기본 구분자
    private static final Pattern DEFAULT_DELIMS = Pattern.compile("[,:]");
    private static final Pattern DIGITS_ONLY = Pattern.compile("^[0-9]+$");

    public void validateTokens(List<String> tokens) {
        if (tokens == null || tokens.isEmpty()) {
            throw new IllegalArgumentException("숫자가 최소 1개 이상이어야 합니다.");
        }

        for (String rawToken : tokens) {
            String token = rawToken == null ? "" : rawToken.trim();

            // 연속된 구분자나 마지막 구분자로 인해 빈 토큰 발생 했는지 체크
            if (token.isEmpty()) {
                throw new IllegalArgumentException("구분자 형식이 잘못되었습니다. (연속 구분자 또는 끝 구분자 금지)");
            }

            // 토큰이 숫자로만 이루어져 있는지 확인
            if (!DIGITS_ONLY.matcher(token).matches()) {
                throw new IllegalArgumentException("숫자와 구분자 외의 문자가 포함되었습니다: " + token);
            }

            // 토큰이 양수인지 확인
            int value = Integer.parseInt(token);
            if (value <= 0) {
                throw new IllegalArgumentException("0 이하의 숫자는 허용되지 않습니다: " + value);
            }
        }
    }

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

        //토큰 유효성 검증
        validateTokens(tokens);

        return tokens;
    }
}
