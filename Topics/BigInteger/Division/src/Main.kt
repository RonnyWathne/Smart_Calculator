fun main() {
    // write your code here
    val a = readln().toBigInteger()
    val b = readln().toBigInteger()

    val (res,rem)= a.divideAndRemainder(b)

    println( a.toString() +" = " +b.toString()+" * " + res.toString()+" + " + rem.toString())



}