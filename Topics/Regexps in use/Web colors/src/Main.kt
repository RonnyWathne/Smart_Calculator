fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    // write your code here
    val matchResult = regexColors.findAll(text)!!
    for (i in matchResult){
        println(i.value)
    }

}