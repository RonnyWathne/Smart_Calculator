fun main() {
    // write your code here
    var input = readln()
    val numbers = input.map { it.toString().toInt() }

    if (numbers.slice(0..(numbers.size/2)-1).sum() ==numbers.slice((numbers.size/2)..numbers.size-1).sum()){
        println("YES")
    }else{
        println("NO")
    }
}