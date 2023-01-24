fun test2() {
    try {
        throw RuntimeException()
    } catch (e: RuntimeException) { }}

fun main() {
    try {
    // write your code here, do not touch the lines above
        val test=1
        test2()
        throw RuntimeException()

    // do not touch the lines below    
    } catch(e: RuntimeException) {
        println("Well")
    } catch (e: Exception) {
        println("Wrong")
    }
}