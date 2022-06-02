/*
[반복문]
1. 조건형 반복문: while, do..while, 조건이 참일 경우 반복을 유지한다.
증가연산자 increment operators ++a, a++ (전위 prefix 연산자, 후위 postfix 연산자)
감소연산자 decrement operators --a, a--
1) while (조건문) {
   }
   조건문이 참일동안 반복.
2) do..while문 : 최초 한 번은 조건 없이 do에서 구문을 진행 후 조건을 실행한다
   do {
   } while (조건문)

2. 범위형 반복문: for문, 반복 범위를 정해 반복을 수행.
1) 증가:
   for (i in 0..9) {
       print(i)
   }
   - 기본적으로 for문은 값을 1씩 증가시키면서 반복한다
     => 1이 아닌 x 증가를 원하면 step x를 붙이면 된다 (i in 0..9 step 3)
   - 변수 i를 0부터 9까지 반복

2) 감소: .. 대신에 downTo 키워드 사용, 스탭 1이 아닌 x증가를 원하면 step x 붙임.
   for (i in 9 downTo 0 step 3) {
       print(i)
   }

3) char 사용:
   for(i in 'a'..'e') {
       print(i)
   }


 */

fun main() {
    var a = 0

    while (a < 5) {
        print(a++) // 후위 연산자. println이 수행된 다음에야 a 값이 증가됨.
    }

    println()

    a = 0;

    do {
        print(++a)
    } while (a < 5)

    println()

    for (i in 0..9 step 3) {
        print(i)
    }

    println()

    for (i in 9 downTo 0 step 3) {
        print(i)
    }

    println()

    for(i in 'a'..'e') {
        print(i)
    }

    }
