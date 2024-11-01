## 다양한 빈 관련 설정 방법

### 1. 빈의 구현체가 여러개인 경우 주입 받는 방법
    1) @Primary : 해당 빈을 최우선으로 주입
    2) @Qualifier("beanName") : beanName으로 지정된 빈을 주입
    3) Set 또는 List로 모두 받기
    4) Property 이름으로 빈과 동일하게 하기 : 가장 흔하게 사용하는 방법

