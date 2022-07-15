/*
null 처리와 동일성의 확인.

1. nullable 변수에서 null을 처리하는 방법

val sample: String? = null
하지만 null 상태로 속성이나 함수를 쓰려고 하면,
null pointer exception이 발생하기 때문에,
nullable 변수를 사용할 때는 null 체크 없이는 컴파일되지 않는다.
if (sample != null)
    println(sample.toUpperCase())

if문으로 조건을 체크하는 대신, 편리한 방법이 있는데.

null safe 연산자
?. null safe 연산자: 먼저 객체가 null인지 확인부터 하고
객체가 null이라면 뒤따라오는 구문을 실행하지 않는다.
sample?.upperCase()

?:elvis 연산자
객체가 null이라면 연산자 우측의 객체로 대체
sample?:"default".uppercase()

!!. non-null assertion 연산자
컴파일 시 null을 체크하지 않아서 런타임시 null pointer exception이 나도록
의도적으로 방치하는 연산자이다
sample!!.upperCase()

null safe 연산자 + 스코프 함수와 사용하면 더욱 편리하다.

    a?.run{
        println(uppercase())
        println(lowercase())
    }

====================================================

2. 변수의 동일성을 체크하는 방법
동일성: 내용의 동일성, 객체의 동일성
1) 내용의 동일성: 서로 다른 메모리 공간에 할당되어 있어도 그 내용이 같으면 같다고 인식
a == b
코틀린의 모든 클래스가 상속받는 'Any'라는 최상위 클래스의 equals() 함수가 반환하는
boolean 값으로 판단하게 된다.
우리가 커스텀 클래스를 만들 때는
open fun equals(other: Any?): Boolean
이런 equals 함수를 상속받아 동일성을 확인해주는 구문을
별도로 구현해야 한다.

2) 객체의 동일성: 서로 다른 변수가 메모리상에 같은 객체를 가리키고 있을 때만 동일하다고 인식
a === b



 */


fun main() {
    var t: String? = null

//    println(a?.uppercase())  // null
//    println(a?:"default".uppercase()) // DEFAULT
//    println(a!!.uppercase()) // Exception in thread...NullPointerException

    t?.run {
        println(uppercase())
        println(lowercase())
    }
    // a이가 null이기 때문에 scope 함수 전체가 실행되지 않는다.

    t = "Kotlin Exam"
    t?.run {
        println(uppercase())
        println(lowercase())
    }

    var a = Product("콜라", 1000)
    var b = Product("콜라", 1000)
    var c = a
    var d = Product("사이다", 1000)

    // 내용의 동일성
    println(a == b) // t
    println(a == c) // t
    println(a == d) // f

    // 객체의 동일성
    println(a === b) // f
    println(a === c) // t
    println(a === d) // f

    // a와 b는 내용은 같지만 객체는 서로 별개이다
    // a와 c는 내용과 객체 모두 일치하고
    // a와 d는 내용과 객체 모두 불일치하다
}



class Product(val name: String, val price: Int) {
    // equals 함수 오버라이드하여
    override fun equals(other: Any?): Boolean {
        // 넘어온 객체가 product라면
        if (other is Product) {
            // 이름과 가격이 모두 같은지를 확인하여 불린 값으로 반환
            return other.name == name && other.price == price
        } else {
            return false
        }
    }
}