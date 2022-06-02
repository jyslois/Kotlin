/*
조건문(Conditional statement)
- if: 참과 거짓만을 비교할 수 있음
- when: 하나의 변수를 여러 개의 값과 비교할 수 있음.
  다만 등호나 부등호의 사용은 불가능하다.
  또한 여러 개의 조건을 만족하는 경우엔, 먼저 부합하는 조건이 실행된다.
  when(a) {
      // 조건값들
      1 -> println("정수 1입니다")
      "DiMo" -> println("디모의 코틀린 강좌입니다.")
      is Long -> println("Long 타입입니다")
      !is String -> println("스트링 타입이 아닙니다.")
      else -> println("어떤 조건도 만족하지 않습니다.")
  }
* Any라는 자료형은 어떤 자료형이든 상관없이 호환되는 코틀린의 최상위 자료형.
비교연산자(Comparison operator)
- 부등호: <=, <, !=, 등등
- 등호: == (할당연산자 =와 다름)
- is 연산자, !is 연산자: a is Int ==> 좌측 변수가 우측 자료형에 호환되는지 여부를 체크하고, 형변환까지 한번에 시켜 줌.
 */

fun main() {
    var a = 3
    if (a > 10) {
        println("10보다 큰 수입니다.")
    } else {
        println("10보다 작은 수입니다.")
    }

    doWhen(1);
    doWhen("DiMo")
    doWhen(1L)
    doWhen(12345)
    doWhen("Coding")

    doWhenExpression(1)

}

// when을 조건에 맞는 동작을 하는 조건문으로서 이용
fun doWhen (a: Any) {
    when(a) {
        1 -> println("정수 1입니다")
        "DiMo" -> println("디모의 코틀린 강좌입니다.")
        is Long -> println("Long 타입입니다")
        !is String -> println("스트링 타입이 아닙니다.")
        else -> println("어떤 조건도 만족하지 않습니다.")
    }
}

// when을 동작 대신 값을 반환하는 표현식expression으로서의 역할을 하게 하려면
// when의 조건으로 동작 대신 값을 써 주면 된다.
// 이렇게 하면, when의 결과 값을 변수에 할당하거나, 직접 값으로서 사용할 수 있다.
fun doWhenExpression (a: Any) {
    var result = when(a) {
        1 -> "정수 1입니다"
        "DiMo" -> "디모의 코틀린 강좌입니다."
        is Long -> "Long 타입입니다"
        !is String -> "스트링 타입이 아닙니다."
        else -> "어떤 조건도 만족하지 않습니다."
    }
    println(result)
}