fun main() {
    // write your code here
    val a = readln().toBigInteger()
    val b = readln().toBigInteger()
    var sum=a+b

    var ten="10".toBigInteger()
    var hundred="100".toBigInteger()

    var (res_a,rem_a)= (a*hundred).divideAndRemainder(sum*hundred)
    var (res_b,rem_b)= (b*hundred).divideAndRemainder(sum*hundred)


    println( ((rem_a / sum)).toString()+"% " + ((rem_b/ sum)).toString()+"%")

}
