fun solution(strings: List<String>, str: String): Int {
    // put your code here
    val inicesList = mutableListOf<Int>()
    for (i in strings.indices) {
        if (strings[i] == str) inicesList.add(1)
    }
    var sum=0
    for (i in inicesList){
        sum +=i
    }
    return sum
}
