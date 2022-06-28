/*
제너릭(Generic): 클래스나 함수에서 사용하는 자료형을 외부에서 지정할 수 있는 기능
함수나 클래스를 선언할 때, 고정적인 자료형 대신 실제 자료형으로 대체되는
타입 패러미터를 받아 사용하는 방법이다.

// 타입 패러미터 T에 특정 자료형이 할당되면, 제너릭을 사용하는 모든 코드는
// 할당된 자료형으로 대체되어 컴파일된다.
// 여러 개의 타입 패러미터 사용 시에 관례적으로 T, U, V를 사용한다

fun <T> genericFunc (param: T): T
class GenericClass <T> (var pref: T)

fun <Int> genericFunc (param: T): T
class GenericClass <Int> (var pref: T)

제너릭을 특정한 슈퍼 클래스를 상속받은 클래스 타입으로만 제한하려면,
<T: SuperClass> 콜론 뒤에 슈퍼클래스 이름을 써 주면 된다.

만약 제너릭 함수를 사용하면
fun <T> genericFunc (param: T): T

genericFun(1) 을 넣어주면, 정수 리터럴이니 Int타입임을 추론 가능해서,
패러미터나 반환형을 통해 타입 페러미터를 자동으로 추론해주고,

클래스일 경우
class GenericClass <T> (var pref: T)

인스턴스를 만들 때
GenericClass<Int>() 타입 페러미터를 수동으로 지정해 주거나,
생성자에 제너릭이 사용된 경우,
GenericClass(1) 타입 페러미터가 자동으로 추론된다.
 */

open class A {
    open fun shout() {
        println("A가 소리칩니다")
    }
}

class B1: A() {
    override fun shout() {
        println("B가 소리칩니다")
    }
}

class C: A() {
    override fun shout() {
        println("C가 소리칩니다")
    }
}

// 슈퍼클래스를 A로 제한한 제너릭 T를 선언
// 생성자에서는 제너릭 T에 맞는 인스턴스 속성 t로 받기
class UsingGenericClass<T:A> (val t: T) {
    fun doShouting() {
        t.shout()
    }
}

fun main() {
    UsingGenericClass(A()).doShouting()
    UsingGenericClass(B1()).doShouting()
    UsingGenericClass(C()).doShouting()

    doShouting(B1())
    // 캐스팅 없이 B의 객체 그대로 함수에서 사용하는 것이다.
}

// 사실 class UsingGeneric(val t:A)해도 동작은 같지만
// Generic을 사용 시에 제너릭이 자료형을 대체하여 캐스팅을 방지할 수 있으므로
// 성능을 좀 더 높일 수 있다

// 슈퍼클래스를 A로 제한한 제너릭 T를 선언
fun <T: A> doShouting (t: T) {
    t.shout()
}