//fun generateSymbol(): Char {
//    val rand = listOf(('!'..'/'), (':'..'@'), ('['..'`'), ('{'..'~')).flatten().random()
//    return rand
//}
fun generateNum(prev: Char): Char {
    var rand = ('0'..'9').random()
    while(true){
        if (rand==prev){
            rand = ('0'..'9').random()
        }else{
            return rand
        }
    }
}
fun generateUpper(prev: Char): Char {
    var rand = ('A'..'Z').random()
    while(true){
        if (rand==prev){
            rand = ('A'..'Z').random()
        }else{
            return rand
        }
    }
}

fun generateLower(prev: Char): Char {
    var rand = ('a'..'z').random()
    while(true){
        if (rand==prev){
            rand = ('a'..'z').random()
        }else{
            return rand
        }
    }
}

fun main() {
    // write your code here
    var pramaters: List<String> = readln().split(" ")
    val result = pramaters.map { it.toInt() }
    //println(result)
    val A=result[0]
    val B=result[1]
    val C=result[2]
    val N=result[3]
    var A_count=0
    var B_count=0
    var C_count=0
    var N_count=0
    var generating=true
    var pass= ""
    while(generating ==true){

        if (A_count < A){
            A_count++
            N_count++
            if(pass.isEmpty()){
                pass=pass+generateUpper('a')
            }else{
                pass=pass+generateUpper(pass.last().toChar())
            }

        }
        if (B_count < B){
            B_count++
            N_count++
            if(pass.isEmpty()){
                pass=pass+generateLower('a')
            }else{
                pass=pass+generateLower(pass.last().toChar())
            }
        }
        if (C_count < C){
            C_count++
            N_count++
            if(pass.isEmpty()){
                pass=pass+generateNum('a')
            }else{
                pass=pass+generateNum(pass.last().toChar())
            }
        }
//        if (N_count < N){
//            N_count++
//            pass=pass+generateSymbol()
//        }
        if (N_count< N && C_count>= C && B_count >= B && A_count >= A){
            N_count++
            if(pass.isEmpty()){
                pass=pass+generateNum('a')
            }else{
                pass=pass+generateNum(pass.last().toChar())
            }
        }

        if (N_count>= N){
            generating=false
        }

    }
    println(pass)

}