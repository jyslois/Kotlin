import java.util.*

/*
코틀린의 타입 추론
변수나 함수들을 선언할 때나, 연산할 때 자료형을 코드에 명시하지 않아도
자동으로 자료형을 추론해주는 기능.
Ex) Val sen = "문자열을 할당" ---> Val sen: String = "..."
Ex) var intArr = arrayOf(1,2,3,4,5)  ---> var intArr: Array<Int> = arrayOf(..)
변수가 선언될 때 할당된 값의 형태로 해당 변수가 어떤 자료형을 가지는지 추론이 가능하기 때문이다.
반드시 특정한 자료형으로 지정해야 하는 상황이 아니라면, 대부분은 코틀린의 타입추론 기능을 이용하여
코드를 줄일 수 있다.
 */

fun main() {
    val sen = "안녕"
    println(sen)

    var intArr = arrayOf(1,2,3,4,5)
    println(Arrays.toString(intArr))

    // 일반 정수형 리터럴을 할당하면 Integer
    var a = 1234
    // L이 붙은 정수형 리터럴은 Long
    var b = 1234L
    // 일반 실수형 리터럴은 Double
    var c = 12.45
    // f가 붙은 실수형 리터럴은 Float형으로 추론된다.
    var d = 12.45f
    // 16진수와 2진수는 Int형으로 추론된다
    var e = 0xABCD
    var f = 0b0101010
    // Boolean과 Char역시 자료형 없이 추론이 가능하다
    var g = true
    var h = 'c'

    println(add(1,2,3))
    println(addSef(1, 2, 3))
}

/*
함수(function): 특정한 동작을 하거나, 원하는 결과값을 연산하는데 사용.
함수는 function의 준말인 fun으로 시작한다.
==> fun 함수이름(매개변수: 자료형, 매개변수: 자료형): 반환형
반환형: 반환하는 값의 자료형. 반환값이 없다면 생략이 가능하다.

단일 표현식 함수(single-expression funtion): 변수에 결과값을 할당하듯 만들 수 있다
단일 표현식 함수에서는 반환형의 타입이 추론 가능하므로, 반환형을 생략할 수 있다.
ex) fun add(a: Int, b: Int, c:Int) = a + b + c

코틀린에서 함수는 내부적으로 기능을 가진 형태이지만,
외부적으로는 파라미터를 넣는다는 점 외에는 자료형이 결정된 변수라는 개념으로 접근하는 것이 좋다.
그래야 이후에 배울 함수형 언어라는 코틀린의 특징을 이해할 수 있다.
 */

fun add(a: Int, b: Int, c: Int): Int {
    return a + b + c
}

// 단일 표현식 함수
fun addSef(a: Int, b: Int, c:Int) = a + b + c
