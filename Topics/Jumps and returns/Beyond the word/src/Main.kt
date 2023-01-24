fun main() {
    // put your code here
    val input = readln()
    for (i in 'a' .. 'z') {
        if(!input.contains(i)) {
            print(i)
        }
    }
}