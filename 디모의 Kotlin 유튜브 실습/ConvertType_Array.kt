/*
코틀린의 형변환과 배열.
1. 형변환 (type casting)
형변환 함수: toDouble(), toInt() toInt()
코틀린에서는 자동 형변환이 허용되지 않고 (암시적 형변환 - 변수 할당시 자료형을 지정하지 않아도 자동으로 형변환 됨),
반드시 to타입()함수를 붙여 주어야 한다. (명시적 형변환 - 변환될 자료형을 개발자가 직접 지정함
 */

/*
배열: 배열의 참조변수와 함께 arrayOf()함수를 이용해 배열에 저잘할 값들을 나열하면 된다.
특정한 크기를 가지는 비어 있는 배열을 만들고 싶으면, arrayOfNulls<자료형 타입>(크기)로 하면 된다. <>은 제너릭.
배열 값 할당하기: intArr[2] 인덱스 번호를 대괄호 안에 쓰고 = 괄호로 값을 할당해주면 된다.
 */

fun main() {
    var a: Int = 12345;
    var b: Long = a.toLong();

    var intArr = arrayOf(1,2,3,4,5)
    var nullArr = arrayOfNulls<Int>(5)

    println(intArr[0]) // 1
    nullArr[0] = 1;
    print(nullArr[0]) // 1
}
