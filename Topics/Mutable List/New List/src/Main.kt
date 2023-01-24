fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    // put your code here
    var tmp= mutableListOf<Int>()
    tmp.addAll(numbers)
    tmp.add(number)
    return tmp
}