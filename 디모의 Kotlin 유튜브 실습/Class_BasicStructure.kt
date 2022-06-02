/*
클래스: '값'과 그 값을 사용하는 '기능'들을 묶어놓은 것.
- 고유의 특정값을 가진 속성과 기능의 구현인 함수로 이루어져 있다.
- 클래스는 인스턴스를 만드는 틀
- 인스턴스: 클래스를 이용해서 만들어내는 서로 다른 속성의 객체
 */

// 속성만 가진 클래스
class Person(var name:String, val birthYear:Int)

// 클래스에 함수 추가하기
class Introduction(var name:String, val birthYear:Int) {
    fun introduce() {
        println("안녕하세요. ${birthYear}년생 ${name}입니다.");
    }
}

fun main() {
    // Person 클래스의 인스턴스를 만들고 참조 변수에 지정해주기
    var a = Person("박보영", 1990)
    var b = Person("전정국", 1997)
    var c = Person("장원영",2004)

    // 변수명.속성명으로 인스턴스 사용하기
    // 이때 중괄호로 전체를 감싸기
    println("안녕하세요. ${a.birthYear}년생 ${a.name}입니다.");

    var d = Introduction("가나다", 1991)
    var e = Introduction("사마다", 1992)
    var f = Introduction("아자카",1990)

    d.introduce()
    e.introduce()
    f.introduce()
}