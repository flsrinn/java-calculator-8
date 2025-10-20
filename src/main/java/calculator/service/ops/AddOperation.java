package calculator.service.ops;

import java.util.ArrayList;

// 덧셈을 수행하는 클래스
public class AddOperation implements Operation{
    @Override
    public int apply(ArrayList<String> tokens) {
        int total = 0;

        for(String token: tokens) {
            int num = Integer.parseInt(token); // 문자열 토큰을 정수로 반환
            total += num; // 합계에 더하기
        }

        return total;
    }
}
