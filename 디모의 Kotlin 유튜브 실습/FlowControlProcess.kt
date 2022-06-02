/*
흐림제어를 위한 키워드
1. return: 함수를 종료하고, 값을 반환한다.
2. break, continue: 반복문에 사용할 수 있다.
- break: 즉시 반복문을 종료하고, 다음 구문으로 넘어간다.
- continue: 다음 반복조건으로 즉시 넘어간다.
- 다중 반복문에서 break나 continue가 적용되는 반복문을 label을 통해 지정할 수 있다
  외부 반복문에 레이블 이름과 @ 기호를 달고, break문에서 @과 레이블 이름을 달아 주면,
  내부 반복문에서 break를 할 경우 바로 외복 반복문에서 빠져나올 수 있다.

논리연산자(logical operators)
논리값을 연산하여 새로운 논리값을 도출할 때 쓰는 연산자.
1. && AND
2. ! NOT
3. || OR
 */

fun main() {

    println("break")
    for (i in 1..10) {
        if (i == 3) {
            break
        }
        println(i)
    }

    println("continue")
    for (i in 1..10) {
        if (i == 3) {
            continue
        }
        println(i)
    }

    println("label")
    outer@for (i in 1..10) {
        for (j in 1..10) {
            println("i : $i, j : $j")
            if (i == 1 && j == 2) {
                break@outer
            }
        }
    }

}