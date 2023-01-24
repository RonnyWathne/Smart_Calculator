fun main() {
    val string = readln()
    // write here
    val subStringToReplace =string.substringAfterLast('u')
    val subStringToKeep=string.substringBeforeLast('u') +"u"


    println(subStringToKeep + subStringToReplace.uppercase())
}