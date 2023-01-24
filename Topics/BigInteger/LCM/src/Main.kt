fun main() {
    // write your code here

    val a = readln().toBigInteger()
    val b = readln().toBigInteger()
    val c = a*b

    val gcd =a.gcd(b)

    println(c/gcd)
}