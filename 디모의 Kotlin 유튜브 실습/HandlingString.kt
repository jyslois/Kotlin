/*
기본적인 문자열을 다루는 방법
val text = "문자열"
String 클래스의 속성과 함수들
length 길이 반환
lowercase() 소문자 변환
uppercase() 대문자 변환
split(".") .을 기준(delimiter) 문자열 자르기
- 자바와는 다르게 정규식이 아닌 일반 문자열을 넣어도 동작한다.
joinToString() 문자열을 한 문자로 합치기
joinToString("-") -을 사이에 넣어서 한 문자로 합치기(separator)
substring(5..10) 문자열 일부분(index 5-10) 자르기

문자열이 비어 있는지 확인하는 함수
isNullOrEmpty() - null이거나 empty이면 true 반환 (정말 비어 있는 것만 인정)
isNullOrBlank() - null이거나 blank이면 true 반환 (비어 있어도 되지만 공백 문자만 있어도 된다)

startsWith("java") - java로 시작하는 문자열이면 true 반환
contains("lin") - lin이 들어간 문자열이면 true 반환
*/

fun main() {
    val test1 = "Test.Kotlin.String"
    println(test1.length)
    println(test1.lowercase())
    println(test1.uppercase())
    val test2 = test1.split(".")
    println(test2); // 문자열 배열로 출력
    // 하나의 문자열로 합치기
    println(test2.joinToString())
    println(test2.joinToString("-"))
    println(test1.substring(5..10))

    // nullable로 String변수 nullString을 만들기기
   val nullString: String? = null
    // 아무것도 넣지 않은 문자열 emptyString
    val emptyString = ""
    // 빈칸을 하나 넣은 blankString
    val blankString = " "
    // normalString
    val normalString = "A"

    println(nullString.isNullOrEmpty())
    println(emptyString.isNullOrEmpty())
    println(blankString.isNullOrEmpty())
    println(normalString.isNullOrEmpty())

    println(nullString.isNullOrBlank())
    println(emptyString.isNullOrBlank())
    println(blankString.isNullOrBlank())
    println(normalString.isNullOrBlank())

    var test3 = "kotlin.kt"
    var test4 = "java.java"

    println(test3.startsWith("java"))
    println(test4.startsWith("java"))

    println(test3.contains("lin"))
    println(test4.contains("lin"))
}