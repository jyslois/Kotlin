/*
람다 함수의 특별한 케이스
1) 구문이 여러 개인 람다 함수  - 마지막 구문의 반환값이 반환된다
2) 패러미터가 없는 람다함수
3) 패러미터가 하나 뿐이라면, it 사용
 */


fun a (function: (String) -> Unit) {
    function("a가 호출.")
}

fun b (function: () -> Unit) {
    function()
}

fun main() {

    // 1. 구문이 여러 개인 람다 함수
    val c: (String) -> Unit = {str ->
        println("$str 람다함수")
        println("여러 구문을")
        println("사용 가능합니다")
    }
    a(c)

    // 2. 패러미터가 없는 람다 함수
    val a: () -> Unit = {println("패러미터가 없어요")}
    b(a)

    // 3. 패러미터가 하나 뿐이라면 it 사용: 패러미터 이름 생략하고 it으로 대체
    val b: (String) -> Unit = {println("$it 람다함수")}
    a(b)


    // 스코프 함수 - 인스턴스 생성하자마자 함수 사용 가능
    // 1) apply
    // apply의 scope 안에서 직접 인스턴스의 속성과 함수를 참조연산자 없이 사용 가능
    // apply는 인스턴스 자신을 다시 반환하기 때문에, 변수에 바로 넣어줄 수 있다
    // main함수와 별도의 scope에서 인스턴스의 변수와 함수를 조작해서 코드가 깔끔해진다.
    var e = Book("디모의 코틀린", 10000).apply {
        name = "[초특가]" + name
        discount()
    }

    // 2) run
    // run - 가격은 출력하지만, 마지막 구문인 이름은 반환하여 변수 f에 할당됨
    // 이미 인스턴스가 만들어진 후에, 인스턴스의 함수나 속성을 scope 내에서 사용해야 할 때 유용하다.
    var f = e.run{
        println(e.price)
        e.name
    }

    e.run {
        println("상품명: ${name}, 가격: ${price}원")
    }

    // 3) with
    with(e) {
        println("상품명: ${name}, 가격: ${price}원")
    }

    // 4) also/let
    e.also{
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }

    e.let{
        println("상품명: ${it.name}, 가격: ${it.price}원")
    }


}

/*
스코프 함수: 람다 함수를 사용한 특별한 기능
인스턴스의 속성이나 함수를 scope내에서 깔끔하게 분리하여 사용할 수 있기 때문에
코드의 가독성을 향상시킨다는 장점이 있다.
클래스의 인스턴스를 scope 함수에 전달하면,
인스턴스의 속성이나 함수를 좀 더 깔끔하게 불러 쓸 수 있다.
1) apply: 인스턴스 생성 후 변수에 담기 전에 초기화 과정을 수행할 때 쓰인다
2) run: run scope 안에서 참조연산자를 사용하지 않아도 되지만, 인스턴스 함수 대신
마지막 구문에 결과값을 반환한다
3) with: run과 동일한 기능을 가지지만, 단지 인스턴스를 참조연산자 대신 패러미터로 받는다.
4) also/let: 단, apply와 run이 참조연산자 없이 인스턴스의 변수와 함수를 사용할 수 있었다면,
also와 let은 마치 패러미터로 인스턴스를 넘긴 것처럼 it을 통해 인스턴스를 사용할 수 있다.
이는 같은 이름의 변수나 함수가 scope 바깥에 중복돼 있는 경우, 혼란을 방지하기 위해서다.
   - apply/also: 처리가 끝나면 인스턴스를 반환
   - run/let: 처리가 끝나면 최정값을 반환
*/

class Book(var name: String, var price: Int) {
    fun discount() {
        price -= 2000
    }
}