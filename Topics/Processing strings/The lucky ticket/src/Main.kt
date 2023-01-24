fun main() {
    // write your code here
    var input = readln()
    val numbers = input.map { it.toString().toInt() }
    if (numbers.slice(0..2).sum() ==numbers.slice(3..5).sum()){
        println("Lucky")
    }else{
        println("Regular")
    }
}