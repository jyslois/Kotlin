/*
데이터를 코드에서 지정한 순서대로 저장해두는 List
데이터를 모아 관리하는 Collection 클래스를 상속받는 클래스(list, set, map) 중
가장 단순한 형태로, 여러 개의 데이터를 원하는 순서대로 넣어 관리하는 형태다.

리스트에는 두 가지가 있다.
1) List<out T> : 생성시에 넣은 객체를 대체, 추가, 삭제할 수 없다.
2) MutableList<T> : 생성시에 넣은 객체를 대체, 추가, 삭제가 가능함.

리스트 생성 - 전용 함수
listOf(1, 2, 3)
mutableListOf("A", "B", "C")

요소의 추가 add(데이터), add(인덱스, 데이터)
요소의 삭제 remove(데이터), removeAt(인덱스)
요소 무작위 섞기 shuffle()
정렬 sort()

list[인덱스] = 데이터
 */

fun main() {
    var a = listOf("사과", "딸기", "배")
    println(a[1])

    // 키워드 in: 리스트 a에서 요소를 하나씩 꺼내 fruit에 할당해 줌
    for (fruit in a) {
        print("${fruit}:")
    }

    println()

    var b = mutableListOf(6, 3, 1)
    println(b)

    b.add(4)
    println(b)

    b.add(2, 8)
    println(b)

    b.removeAt(1)
    println(b)

    b.shuffle()
    println(b)

    b.sort()
    println(b)
}