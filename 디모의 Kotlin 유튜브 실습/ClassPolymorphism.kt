/*
클래스의 다형성: 클래스의 상속관계에서 오는 인스턴스의 호환성을 활용할 수 있는 기능으로,
슈퍼클래스가 같은 인스턴스를 한 번에 관리하거나 인터페이스를 구현하여 사용하는 코드에서도
이용된다.

슈퍼클래스 변수에 자손 인스턴스를 담는 행위를 상위 자료형인 슈퍼클래스로 변환한다고 하여,
Up-Casting이라고 하고, up-casting된 자료형을 다시 하위 자료형으로 변환하면,
down-casting이라고 한다. 다운캐스팅일 경우 별도의 연산자가 필요하다. - as / is
1) as: 변수를 호환되는 자료형으로 변환해 주는 캐스팅 연산자이다.
var a: Drink = Cola()
a as Cola
이 이후로는 Cola로 작동한다.
또한 변환한 결과를 반환받아 변수에 넣을 수도 있다.
var b = a as Cola
2) is: 변수가 자료형에 호환되는지를 먼저 체크한 후 변환해주는 캐스팅 연산자로,
조건문 내에서 사용되는 특징이 있다.
var a: Drink = Cola()
if (a is Cola)
{
이 안에서만 a가 Cola가 됨
}
 */


// 상속이 가능한 open class
open class Drink {
    var name = "음료"

    open fun drink() {
        println("${name}을 마십니다")
    }
}

class Cola: Drink() {
    var type = "콜라"

    override fun drink() {
        println("${name} 중에 ${type}을 마십니다")
    }

    fun washDishes() {
        println("${type}로 설거지를 합니다")
    }
}

fun main() {
    // Drink 인스턴스 생성 후 변수 a에 할당
    var a = Drink()
    a.drink()

    // b는 Drink타입의 변수이지만, Cola의 인스턴스 변수를 담았으므로
    // Cola에서 override한 함수가 실행된다
    // 하지만 Drink타입의 변수이기 때문에, washDishes를 호출할 수 없다.
    var b: Drink = Cola()
    b.drink()
    // 때문에 b를 Cola타입으로 다운캐스팅 해 주어야 한다(as)
    // as를 사용하면 반환값 뿐 아니라 변수 자체도 다운캐스팅 된다
    b as Cola
    b.washDishes()
    // 혹은 변수에 할당 후 호출
    var c = b as Cola
    c.washDishes()
    // 혹은
    if (b is Cola) {
        b. washDishes()
    }
}