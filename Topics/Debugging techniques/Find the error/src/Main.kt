import java.util.Scanner

fun swapInts(ints: IntArray): IntArray {
    return intArrayOf(ints[1], ints[0])
}

fun main() {
    val number1 = readln().toInt()
    val number2 = readln().toInt()

    val ints: IntArray=  swapInts(intArrayOf(number1, number2))
        println(ints[0])
        println(ints[1])
}
