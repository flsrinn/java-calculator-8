package calculator.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 입력된 문자열에서 커스텀 구분자와 숫자 부분을 분리
public class DelimiterParser {

    // 커스텀 구분자가 있음을 나타내는 접두사
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    // 커스텀 구분자 형식 추출을 위한 정규표현식 패턴
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("^//(.+?)(?:\\\\n|\\n)(.*)$", Pattern.DOTALL);

    public String[] parse(String input) {
        // 커스텀 구분자 사용 X -> 기본 구분자
        if(!input.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return new String[] {input, null};
        }

        // 정규식 패턴으로 커스텀 구분자와 계산식을 찾음
        Matcher m = CUSTOM_PATTERN.matcher(input);
        if (m.find()) {
            String delimiter = m.group(1); // 첫번째 그룹 - 구분자
            String body = m.group(2); // 두번째 그룹 - 숫자
            return new String[]{body, delimiter};
        }

        // TODO: 커스텀 구분자 형식이지만, 패턴에 맞지 않는 경우 예외 처리 구현 예정
        return new String[] {input, null};
    }

}
