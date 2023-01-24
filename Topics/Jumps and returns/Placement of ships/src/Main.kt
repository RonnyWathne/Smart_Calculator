import java.util.Scanner;

fun main() {
    // put your code here
    var freeX=mutableListOf(1,2,3,4,5)
    var freeY=mutableListOf(1,2,3,4,5)

    val scan = Scanner(System.`in`)


    while(scan.hasNext()){
      var input3=  scan.nextLine()
        //println(input3)
        val input2=input3.split(" ")
        var numberList = input2.map { it.toInt() }
        if (freeX.contains(numberList[0])){
            freeX.remove(numberList[0])
        }
        if (freeY.contains(numberList[1])){
            freeY.remove(numberList[1])
        }

        }
    for(x in freeX){
        print(x)
        if(x==freeX.last()){
            continue
        }
        print(" ")
    }
    println("")
    for(y in freeY){
        print(y)
        if(y==freeY.last()){
            continue
        }
        print(" ")
    }
//    println("")
//    println(freeX)
//    println(freeY)
}


//
//    for(x in 1 .. 5){
//        val input = readln()
//        val input2=input.split(" ")
//        var numberList = input2.map { it.toInt() }
//
//        for(j in 1 .. 5){
//
//        }
//    }
//
//    val input = readln()
//    val input2=input.split(" ")
//    var numberList = input2.map { it.toInt() }
