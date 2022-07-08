/*
�⺻���� ���ڿ��� �ٷ�� ���
val text = "���ڿ�"
String Ŭ������ �Ӽ��� �Լ���
length ���� ��ȯ
lowercase() �ҹ��� ��ȯ
uppercase() �빮�� ��ȯ
split(".") .�� ����(delimiter) ���ڿ� �ڸ���
- �ڹٿʹ� �ٸ��� ���Խ��� �ƴ� �Ϲ� ���ڿ��� �־ �����Ѵ�.
joinToString() ���ڿ��� �� ���ڷ� ��ġ��
joinToString("-") -�� ���̿� �־ �� ���ڷ� ��ġ��(separator)
substring(5..10) ���ڿ� �Ϻκ�(index 5-10) �ڸ���

���ڿ��� ��� �ִ��� Ȯ���ϴ� �Լ�
isNullOrEmpty() - null�̰ų� empty�̸� true ��ȯ (���� ��� �ִ� �͸� ����)
isNullOrBlank() - null�̰ų� blank�̸� true ��ȯ (��� �־ ������ ���� ���ڸ� �־ �ȴ�)

startsWith("java") - java�� �����ϴ� ���ڿ��̸� true ��ȯ
contains("lin") - lin�� �� ���ڿ��̸� true ��ȯ
*/

fun main() {
    val test1 = "Test.Kotlin.String"
    println(test1.length)
    println(test1.lowercase())
    println(test1.uppercase())
    val test2 = test1.split(".")
    println(test2); // ���ڿ� �迭�� ���
    // �ϳ��� ���ڿ��� ��ġ��
    println(test2.joinToString())
    println(test2.joinToString("-"))
    println(test1.substring(5..10))

    // nullable�� String���� nullString�� ������
   val nullString: String? = null
    // �ƹ��͵� ���� ���� ���ڿ� emptyString
    val emptyString = ""
    // ��ĭ�� �ϳ� ���� blankString
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