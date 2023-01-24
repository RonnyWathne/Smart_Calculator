fun main() {
    val mutList: MutableList<Int> = mutableListOf()
    val shiftMutList: MutableList<Int> = mutableListOf()

    var inputSize = readln().toInt()
    for (i in 0 until inputSize) {
        mutList.add(readln().toInt())
    }


    val shiftNum = readln().toInt()


    for (i in 0..inputSize-1){

        var tmp = (i-shiftNum).mod(inputSize)
        shiftMutList.add(mutList[tmp])

    }
    for (i in shiftMutList) {
        print("${i} ")
    }
}