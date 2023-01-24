fun isPrimeNo(number: Int): Boolean {
    if(number==1) return true
    if(number<2) return false
    for (i in 2..number/2) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}

fun printIfPrime(number: Int) {
    // write here
    if (isPrimeNo(number)){
        println(number.toString() + " is a prime number.")
    }else{
        println(number.toString() + " is not a prime number.")
    }
}

fun main(args: Array<String>) {
    // write here
    val number = readln().toInt()
    printIfPrime(number)
}