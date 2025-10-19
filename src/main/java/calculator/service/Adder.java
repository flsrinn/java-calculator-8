package calculator.service;

import java.util.ArrayList;

// 문자열 형태의 숫자 토큰 리스트를 받아 합계 계산
public class Adder {
    public int sum(ArrayList<String> tokens) {
        int total = 0;

        for(String token: tokens) {
            int num = Integer.parseInt(token); // 문자열 토큰을 정수로 반환
            total += num; // 합계에 더하기
        }

        return total;
    }
}
