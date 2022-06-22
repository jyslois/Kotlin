/*
Object: 생성자 없이 객체를 직접 만들어 낸다
여러 인스턴스 객체가 필요하지 않고, 단 하나의 객체만으로 공통적인 속성과 함수를
사용해야 하는 코드에서는, 굳이 클래스를 쓸 필요없이 Object를 사용하면 된다.
Singleton Pattern; 클래스의 인스턴스를 단 하나만 만들어 사용하도록 하는
코딩 아키텍쳐 패턴, 을 언어 차원에서 지원하는 것이다.
object라는 키워드를 사용해서 만든다.
object는 인스턴스를 생성하지 않고, 그 자체로 객체이기 때문에, 생성자는 사용하지 않는다.
object로 선언된 객체는 최초 사용시 자동으로 생성되며, 이후에는
코드 전체에서 공용으로 사용될 수 있으므로, 프로그램이 종료되기 전까지
공통적으로 사용할 내용들을 묶어 만드는 것이 좋다.

기존 클래스 안에도 object를 만들 수 있다
Companion Object
인스턴스 간의 공용 속성 및 함수를 별도로 만든 것이다(Static 멤버와 비슷)
호출할 때는 클래스이름.공용object변수이름 하면 된다
*/

object Counter {
    var count = 0;

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}


fun main() {
    // object는 별도의 인스턴스를 생성하지 않기 때문에,
    // object이름에 직접 참조연산자를 붙여 사용한다.

    println(Counter.count)
    Counter.countUp()
    Counter.countUp()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)

    var a = FoodPoll("짜장")
    var b = FoodPoll("짬뽕")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.name} : ${a.count}")
    println("${b.name} : ${b.count}")
    println("총계 : ${FoodPoll.total}")
}

class FoodPoll (val name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}