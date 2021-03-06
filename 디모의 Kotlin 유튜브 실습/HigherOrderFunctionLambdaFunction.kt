/** 고차 함수
함수를 마치 클래스에서 만들어낸 인스턴스처럼 취급하는 방법
함수를 패러미터로 넘겨줄 수도 있고, 결과값으로 반환받을 수도 있는 방법이다
코틀린에서는 모든 함수를 고차 함수로 구현 가능하다
패러미터로 넘겨 줄 때, (function: (자료형, 자료형, ...) -> 자료형)
형식으로 넘겨주며, 반환값이 없을 때는 (페러미터 자료형) -> Unit 처럼
Unit을 써 주면 된다.
main function에서 일반 함수를 고차 함수로 변경해주는 연산자는 ::이다.
 */

fun a (str: String) {
    println("$str 함수 a")
}

fun b (function: (String) -> Unit) {
    function("b가 호출한")
}


fun main() {
    b(::a) // b가 호출한 함수 a

    val c: (String) -> Unit = {str -> println("$str 람다함수")}

    b(c) // b가 호출한 람다 함수
}

/* 람다 함수
패러미터로 넘길 함수를 따로 만들 필요없이
람다 함수는 일반 함수와 달리, 그 자체가 고차 함수이기 때문에,
별도의 연산자 없이도 변수에 담을 수 있다.
 val c: (String) -> Unit = {str}
일반 변수에 자료형을 쓰듯, 그 자리에 함수의 형식을 쓴 것이다.
str은 String으로 받아온 값을 람다함수 내에서 사용할 변수 이름이다
원래는 str:String 이렇게 써야 하지만, 여기선 이미 패러미터의
자료형이 기술되어 있기 때문에 자료형이 자동으로 추론되므로, 생략 가능하다.

람다 함수 역시 변수에 할당할 때는, 이전에 배웠던 타입 추론 기능을 이용하여
촘 더 축약해서 기술할 수 있다.
val c: {str:String -> println("$str 람다함수")}
*/