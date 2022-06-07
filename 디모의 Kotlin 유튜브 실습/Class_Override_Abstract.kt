/*
슈퍼 클래스에서 허용할 경우, 서브 클래스에서 오버라이딩을 할 수 있다.
슈퍼 클래스의 open이 붙은 함수는 서브 클래스에서 override 키워드를 붙여 재구현 할 ㅜㅅ 있다.
 */

open class Animals {
    open fun eat() {
        println("음식을 먹습니다")
    }
}

class Tiger: Animals() {
    override fun eat() {
        println("고기를 먹습니다")
    }
}

/*
슈퍼 클래스에서 메서드를 추상화 할 경우 선언부만 있고 기능이 구현되지 않은 메서드를
만드는 것이고 (추상 함수) - 추상 클래스, 서브클래스가 그 메서드의 기능을 구현한다.
abstract 추상 클래스: abstract 추상 함수를 포함한다.
서브 클래스는 추상 클래스를 상속받은 다음, override 키워드를 붙여 추상 함수를 완성한다.
*/

abstract class absAnimal {
    // 추상 함수
    abstract fun eat()
    // 일반 함수
    fun sniff() {
        println("킁킁")
    }
}

class Rabbit : absAnimal() {
    override fun eat() {
        println("당근을 먹습니다")
    }
}

/* 인터페이스: 코틀린에서는 인터페이스 역시 속성, 추상함수와 일반 함수 모두를 가질 수 있다.
다만, 추상함수는 생성자를 가질 수 있는 반면, 인터페이스는 생성자를 가질 수 없으며,
인터페이스에서 구현부가 있는 함수는 open 함수로 간주, 구현부가 없는 함수는 abstract함수로
간주하기 때문에, 별도의 키워드가 없어도 포함된 모든 함수를 서브클래스에서 구현 및 재정의가 가능하다.
또한 한 번에 여러 인터페이스를 상속 받을 수 있어서 좀 더 유연한 설계가 가능하다.
서브 클래스가 슈퍼 클래스의 추상함수/일반 함수를 구현/재구현 할 때는 키워드 override를 붙여준다.
단, 여러 인터페이스에서 같은 이름의 함수를 구현하고 있다면, 서브 클래스에서는 혼선이 일어나지 않도록
반드시 오버라이딩하여 재구현 해주어야 한다.
 */

interface Runner {
    fun run()

}

interface Eater {
    fun eat() {
        println("음식을 먹습니다")
   }
}

class Dogs : Runner, Eater {
    override fun run() { // 구현
        println("우다다다 뜁니다")
    }
    override fun eat() { // 재구현
        println("허겁지겁 먹습니다")
    }
}


fun main() {
    var t = Tiger();
    t.eat()

    var r = Rabbit()
    r.eat()
    r.sniff()

    var d = Dogs()
    d.run()
    d.eat()
}