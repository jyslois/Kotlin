/*
클래스의 상속:
슈퍼 클래스: 부모 클래스
서브 클래스: 자식 클래스스
코틀린은 상속 금지가 기본값이다.
open은 클래스가 상속될 수 있도록 클래스 선언 시 붙여줄 수 있는 키워드다.
- 서브 클래스는 슈퍼 클래스에 존재하는 속성과 같은 이름의 속성을 가질 수 없다
- 서브 클래스가 생성될 때는 반드시 슈퍼 클래스의 생성자까지 호출되어야 한다
그래서 서브 클래스를 만들 때는, 클래스 자체 속성으로 만들어주는 var/val을
붙이지 말고 일반 패러미터로 받아, 슈퍼 클래스의 생성자에 직접 넘겨주어야 한다.
서브 클래스는 뒤에 :슈퍼클래스(슈퍼 클래스 생성자 호출) 식으로 상속받는다.
*/

fun main() {
    // Animal 클래스의 a 인스턴스와 Dog 클래스의 b 인스턴스
    var a = Animal("별이", 5, "개")
    var b = Dog("별이", 5)
    var c = Cat("루이",1)

    a.introduce()
    b.introduce()
    b.bark()

    c.introduce()
    c.meow()

}
open class Animal(var name:String, var age:Int, var type:String) {
    fun introduce() {
        println("저는 ${type} ${name}이고, ${age}살입니다.")
    }
}

class Dog(name:String, age:Int) : Animal(name, age, "개") {
    fun bark() {
        println("멍멍")
    }
}

class Cat(name:String, age:Int) : Animal(name, age,"고양이") {
    fun meow() {
        println("야옹야옹")
    }
}