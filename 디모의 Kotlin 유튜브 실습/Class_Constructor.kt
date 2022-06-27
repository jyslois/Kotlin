/*
생성자: 새로운 인스턴스를 만들기 위해 호출하는 특수한 함수.
생성자를 사용하면, 클래스에 인스턴스를 만들어 반환 받을 수 있다.

class Person(var name:String, val birthYear:Int)
클래스를 선언함과 동시에 생성자 역시 선언하는 방법이다.

생성자는 인스턴스의 속성을 초기화하고, 또한 init이라는 함수를 통해
인스턴스 생성시 필요한 구문을 수행하는 역할도 할 수 있다.
init 함수는 패러미터나 반환형이 없는 특수한 함수이다.
생성자를 통해 인스턴스가 만들어질 때, 호출되는 함수이다.

class PersonID (var name:String, val birthYear:Int) {
    init {
        println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")
    }
}

기본 생성자: 클래스를 만들 때 기본으로 선언
보조 생성자(Secondary Constructor): 필요에 따라 추가적으로 선언
보조 생성자는 constructor라는 키워드를 사용해서 만든다.
보조 생성자를 만들 때는, 반드시 기본 생성자를 통해 속성을 초기화 해 주어야 한다.
보조 생성자가 기본 생성자를 호출하도록 하려면, 콜런 :을 붙인 후 this라는
키워드를 사용하고, 기본생성자가 필요로 하는 패러미터를 괄호 안에 넣어주면 된다.
이때 변수의 초기화 값을 고정으로 주려면 알맞게 값을 할당하면 된다.

 constructor(name:String) : this(name, 1997) {
        println("보조 생성자가 사용되었습니다.")
    }
 */

class PersonID (var name:String, val birthYear:Int) {
    init {
        // 이때 this는 인스턴스 자신의 속성이나 함수를 호출하기 위해 클래스 내부에서 사용되는 키워드.
        println("${this.birthYear}년생 ${this.name}님이 생성되었습니다.")
    }

    constructor(name:String) : this(name, 1997) {
        println("보조 생성자가 사용되었습니다.")
    }
}

fun main() {
    var a = PersonID("박보영", 1990)
    var b = PersonID("전정국", 1997)
    var c = PersonID("장원영", 2004)

    var d = PersonID("이루다")
    var e = PersonID("차은우")
    var f = PersonID("류수정")
}