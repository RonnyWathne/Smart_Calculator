fun main() {
    // put your code here
    val input = readln()
    for (i in input){
        if(i.isDigit()){
            println(i)
            break
        }
    }
}