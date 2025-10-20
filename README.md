# 프리코스 1주차 - 문자열 덧셈 계산기

---

## 기능 목록

### 1) 문자열 입력 받기
- `camp.nextstep.edu.missionutils.Console.readLine()` 활용

### 2) 기본 구분자 처리 
- `"1,2"` -> 3
- `"1,2,3"` -> 6
- `"1,2:3"` -> 6

### 3) 커스텀 구분자 처리
- 형식: `"//<구분자>\n<숫자들>"`
- 예시: `"//;\n1;2;3"` -> 6

### 4) `IllegalArgumentException` 발생 조건
- 커스텀 구분자 선언 형식이 올바르지 않은 경우
- 입력값이 숫자와 구분자 외의 문자를 포함할 경우
- 연속된 구분자 또는 마지막에 구분자가 있는 경우
- 음수 또는 0이 포함될 경우

### 5) 계산 및 출력 
- 선택한 연산에 따라 결과 계산
- 계산 결과 출력 예시: `결과 : 6`

## 프로그램 구성 (MVC 구조)
- `Application.java`: 프로그램 실행 시작점
- `/controller`
  - `CalculatorController.java`: 프로그램의 전체 실행 흐름 제어
- `/view`
  - `InputView.java`: 사용자 입력
  - `OutputView.java`: 계산 결과 출력
- `/service`
  - `StringCalculatorService.java`: 계산 과정의 흐름을 관리하며 아래 모듈들을 순서대로 호출
    - `/utils`
      - `DelimiterParser.java`: 입력 형식 검증 + 커스텀 구분자/계산식 추출
      - `TokenSplitter.java`: 토큰 분리 + 숫자/토큰 검증
    - `/ops`
      - `Operation.java` : 연산 전략 인터페이스
      - `AddOperation.java`: 토큰을 정수로 변환하고 합계를 계산
      - `OperationType.java` : 연산 종류 enum (ADD, SUBTRACT, MULTIPLY, DIVIDE)
      - `OperationFactory.java` : 타입 → 전략 매핑 팩토리