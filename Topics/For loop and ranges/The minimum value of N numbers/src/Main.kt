fun main() {
    // write your code here
    val N = readln().toInt()
    var minval=Int.MAX_VALUE
    for (i in 1.. N){
        val input = readln().toInt()
        if (input<minval){
            minval=input
        }
    }
    println(minval)

}