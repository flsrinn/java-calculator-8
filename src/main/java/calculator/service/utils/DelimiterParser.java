package calculator.service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 입력된 문자열에서 커스텀 구분자와 숫자 부분을 분리
public class DelimiterParser {

    // 커스텀 구분자가 있음을 나타내는 접두사
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    // 커스텀 구분자 형식 추출을 위한 정규표현식 패턴
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.+?)(?:\\\\n|\\n)(.*)$", Pattern.DOTALL);

    public String[] parse(String raw) {
        if (raw == null) throw new IllegalArgumentException("입력이 비어 있습니다.");
        String input = raw.strip();
        if (input.isEmpty()) throw new IllegalArgumentException("입력이 비어 있습니다.");

        // 기본 구분자 모드
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return new String[]{input, null};
        }

        // 커스텀 구분자 모드
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (!m.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식 오류: (//<구분자>\\n<숫자들>)");
        }

        String delimiter = m.group(1);
        String body = m.group(2);

        if (delimiter.isEmpty()) {
            throw new IllegalArgumentException("구분자가 비어 있습니다.");
        }
        if (body == null || body.isBlank()) {
            throw new IllegalArgumentException("숫자 본문이 비어 있습니다.");
        }

        return new String[]{body, delimiter};
    }
}
