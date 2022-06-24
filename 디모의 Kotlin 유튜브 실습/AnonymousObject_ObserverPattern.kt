/*
Observer: 이벤트가 일어나는 것을 감시하는 감시자의 역할을 만든다
ex) 안드로이드: 키의 입력, 더치의 발생, 데이터 수신 등 함수로 직접 요청하지 않았지만,
시스템 또는 루틴에 의해서 발생하게 되는 동작드를 '이벤트'라고 부르며,
이 이벤트가 발생할 때마다 즉각적으로 처리할 수 있도록 만드는 프로그래밍 패턴을
ObserverPattern이라고 부른다.
ObserverPattern에 필요한 두가지:
1) 이벤트를 수신하는 클래스
2) 이벤트의 발생 및 전달하는 클래스: 이벤트가 발생했다고 1)에게 전달하고 1)의 함수를 호출
두 클래스 사이의 통신을 위해 인터페이스를 끼워넣는다.
2)에서는 자신의 이벤트를 받을 수 있는 인터페이스를 만들어 공개하고,
1)은 2)를 구현하여 2)에 넘겨주면, 인터페이스만 알아도 이벤트를 넘겨줄 수 있다.
이때 이 인터페이스를 observer, 또는 listener라고 부르며, 이렇게 이벤트를
넘겨주는 행위를 callback이라고 한다.
*/

// 이벤트를 수신해서 출력하는 EventPrinter 클래스
// 숫자를 카운트하며 5의 배수마다 이벤트를 발생시킬 Counter 클래스
// 그리고 이 두개를 연결시킬 인터페이스 EventListener

// 이벤트가 발생할 때 숫자를 반환해 준다
// 리스너를 통해 이벤트를 반환하는 함수 이름은 on(행위)라는 규칙을 따른다.
interface EventListener{
    fun onEvent(count: Int)
}

// 이벤트가 발생되는 클래스
class Counter11(var listener: EventListener) {
    fun count() {
        for (i in 1..100) {
            if (i % 5 == 0) listener.onEvent(i)
        }
    }
}

//// 이벤트를 받아서 화면에 출력할 EventPrinter
//// EventListener을 상속해서 구현시켜 주어야 한다.
//class EventPrinter: EventListener {
//    override fun onEvent(count: Int) {
//        print("${count}-")
//    }
//    fun start() {
//        var counter = Counter11(this)
//        // 여기서 this는 EventPrinter 그 자신이지만,
//        // 받는 쪽에서 EventListener을 요구했기 때문에
//        // 그 구현 부분만 넘겨주게 된다 (객체지향의 다형성)
//        counter.count();
//    }
//}

// EventPrinter 클래스가 EventListener을 상속 받는 대신
// 임시로 만든 EventListener 객체를 넘겨줄 수 있는데, 이것을
// 이름 없는 객체라 하여 익명객체라고 한다.
// 이렇게 만들면 인터페이스를 구현한 객체를 코드 중간에도 즉시 생성하여 사용할 수 있다.

class EventPrinter {
    fun start() {
        var counter = Counter11(object: EventListener {
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })
        counter.count()
    }
}

fun main() {
    EventPrinter().start()
    // EventPrinter 내애서 구현된 EventListener에서 출력한다
}