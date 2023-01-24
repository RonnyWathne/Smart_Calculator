import java.util.*

fun main() {
    // put your code here
    //fun main() { //sampleStart val i = 10 println("i = $i") // Prints "i = 10" //sampleEnd }

    var scanner_variable: Scanner  = Scanner(System.`in`)
    var firstName = scanner_variable.next()
    //println(firstName)
    //var lastName = readln()
    var lastName = scanner_variable.next()
    //println(lastName)
    var age = scanner_variable.next().toInt()
    //println(age)
    println("${firstName[0]}. $lastName, $age years old")
}