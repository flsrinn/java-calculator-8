package calculator.service.utils;

import java.util.List;
import java.util.regex.Pattern;

// 입력한 문자열과 분리된 토큰들의 유효성 검증
public class InputValidator {

    // 커스텀 구분자 선언부의 형식을 검증하기 위한 정규식
    private static final Pattern CUSTOM_HEADER = Pattern.compile("^//(.+?)(?:\\\\n|\\n).*$", Pattern.DOTALL);
    private static final Pattern DIGITS_ONLY = Pattern.compile("^[0-9]+$");

    // 커스텀 선언 형식 검증: // 로 시작해도 형식에 안 맞으면 예외
    public void validateCustomHeaderFormat(String raw) {
        if (raw == null) throw new IllegalArgumentException("입력이 비어 있습니다.");
        if (raw.startsWith("//") && !CUSTOM_HEADER.matcher(raw).matches()) {
            throw new IllegalArgumentException("커스텀 구분자 선언 형식이 올바르지 않습니다. (//<구분자>\\n<숫자들>)");
        }
    }

    // 토큰 유효성 검증
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
}
