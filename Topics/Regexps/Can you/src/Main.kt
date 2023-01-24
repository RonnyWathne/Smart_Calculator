fun main() {
    val answer = readln()
    // write your code here
    val regex = Regex("I ca(n't|n) do my homework on time!")
                           // I can't do my homework on time!
    if(answer.matches(regex) ){
        println(true)
    }else{
        println(false)
    }

}