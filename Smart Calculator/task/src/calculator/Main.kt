package calculator

import java.math.BigInteger

fun isNumericToX(symbol: String): Boolean {
    return symbol.toDoubleOrNull() != null
}

fun findInvalidInput(input:String):Boolean{
    val regexChar = "[A-Za-z]".toRegex()
    val regexNum = "[1-9]".toRegex()
    var lastNonwhitespace=' '
    for (i in input){
        if(lastNonwhitespace ==' ' && (i=='+' || i=='-' || i=='*'|| i=='/')){
            return true
        }
        if(lastNonwhitespace =='+' && ( i=='-' || i=='*'|| i=='/')){
            return true
        }
        if(lastNonwhitespace =='-' && ( i=='+' || i=='*'|| i=='/')){
            return true
        }
        if(lastNonwhitespace =='*' && ( i=='+' || i=='*'|| i=='/'|| i=='-')){
            return true
        }
        if(lastNonwhitespace =='/' && ( i=='+' || i=='*'|| i=='/'|| i=='-')){
            return true
        }
        if(lastNonwhitespace =='(' && ( i=='+' || i=='*'|| i=='/'|| i=='-')){
            return true
        }
        if(lastNonwhitespace =='(' && ( i=='+' || i=='*'|| i=='/'|| i=='-')){
            return true
        }
        if(lastNonwhitespace.toString().matches(regexChar)  && ( i.toString().matches(regexNum))){
            return true
        }
        if(lastNonwhitespace.toString().matches(regexNum)  && ( i.toString().matches(regexChar))){
            return true
        }
        if(i !=' '){
            lastNonwhitespace=i
        }

    }
    return false
}
fun parenthesisCheck(input: String):Boolean{
    var leftParenthesisCount=0
    var rightParenthesisCount=0

    for (i in 0..input.length-1){
        if (  input[i] == '(' ){
            leftParenthesisCount++
        }else if( input[i] ==')'){
            rightParenthesisCount++
            if(rightParenthesisCount>leftParenthesisCount){
                return false
            }
        }
    }
    return rightParenthesisCount==leftParenthesisCount
}

fun assignToMemory(memory: MutableMap<String, BigInteger>,filteredAndDelimited:List<String>): MutableMap<String, BigInteger>{
    //println(filteredAndDelimited)
    var tmp =memory[filteredAndDelimited[1]]
    if (filteredAndDelimited[0].matches("[a-zA-Z]+".toRegex()) && isNumericToX(filteredAndDelimited[1])){
        memory.put(filteredAndDelimited[0],filteredAndDelimited[1].toBigInteger())
    }else if(filteredAndDelimited[0].matches("[a-zA-Z]+".toRegex()) && filteredAndDelimited[1] in memory.keys){
        if (tmp != null) {
            memory.put(filteredAndDelimited[0],tmp)
        }
    }else{
        println("Invalid assignment")
    }

    return memory
}


fun main(args: Array<String>) {
    var quit=false
    var memory= mutableMapOf<String,BigInteger>()
    runningLoop@while (!quit) {
        val input = readln()
        //println(input)
        if (input.isEmpty()) {
            continue
        }
        //commands
        if (input[0] == '/') {
            if (input == "/exit") {
                println("bye")
                quit = true
                continue@runningLoop
            } else if (input == "/help") {
                println("The program calculates the sum of numbers.")
                println("There must be plus and minus operations between each number.")
                println(
                    "There must at leas one space between each number or math operation(negative numbers does " +
                            "not need to be separated frm their number"
                )
                println("calculator can either make a memory assignment or calculate an input")
                continue@runningLoop
            } else {
                println("Unknown command")
                continue@runningLoop
            }
        }

        //check for formatting errors
        if (findInvalidInput(input)) {
            println("Invalid expression")
            continue@runningLoop
        }
        if (!parenthesisCheck(input)) {
            println("Invalid expression")
            continue@runningLoop
        }
        // calculator can either make a memory assignment or calculate an input (memory may need to remember negative numbers)
        if (input.contains('=') && (input.contains('+')  || input.contains('*') || input.contains(
                '/') || input.contains('(') || input.contains(')'))) {
            println("invalid input")
            continue@runningLoop
        }
        // no more than one equal sign
        if (input.filter { it == '=' }.count() > 1) {
            println("Invalid expression")
            continue@runningLoop
        }
        //make a memory assignment
        if (input.contains('=')) {
            //println("test")
            val filtered = input.replace("\\s+".toRegex(), "")
            val filteredAndDelimited = filtered.split("=")
            if (filteredAndDelimited.size > 3) {
                println("filteredAndDelimited too long?")
                continue@runningLoop
            }
            memory = assignToMemory(memory, filteredAndDelimited)
            //println(memory)
            continue@runningLoop
            // if input contains no operators. search memory and output
        } else if (!input.contains(' ') && !input.contains('+') && !input.contains('-') && !input.contains('=') && !input.contains(
                '*') && !input.contains('/') && !input.contains('(') && !input.contains(')')) {
            if (input in memory.keys) {
                println(memory[input])
                continue@runningLoop
            } else {
                println("Unknown variable")
            }
            continue@runningLoop
        }


        var processResult= processInput(input,memory)

        var partialList= mutableListOf<String>()
        var loopTrue=false

        if (processResult.contains(")")){
            partialList =parenthesisSeparateInputList(processResult)
            if (partialList.contains(")")){loopTrue =true}

        }
        while(loopTrue){
            loopTrue=false
            partialList =parenthesisSeparateInputList(partialList)
            if (partialList.contains(")")){loopTrue =true}
        }
        if (processResult.contains(")")){
            println(calculateList(partialList)[0].toBigInteger().toString())
        }else{
            println(calculateList(processResult)[0].toBigInteger().toString())
        }
    }
}

fun processInput(input:String, memory: MutableMap<String, BigInteger> ):MutableList<String>{
    //println(input)
    var filtered2 = input.replace("\\s+".toRegex(), " ")
    var reg = Regex("(?<=[/////*?/s//+\\-//(//)])|(?=[/////*?/s//+\\-//(//)])")
    var filteredAndDelimited = filtered2.split(reg).toMutableList()
    filteredAndDelimited=processMutList(filteredAndDelimited)

    // replacing memory values
    var checker=""
    for (i in 0.. filteredAndDelimited.size-1){  // assign memory
        checker= filteredAndDelimited[i].replace(" ", "")
        if (checker in memory.keys){
            filteredAndDelimited[i]=memory[checker].toString()
        }
    }
    return filteredAndDelimited
}
fun processMutList(input: MutableList<String>):MutableList<String> {
    while (input.contains(" ")) {
        input.remove(" ")
    }
    while (input.contains("")) {
        input.remove("")
    }
    var lastElement = ""
    var countMinus = 0
    var restart = true
    whileLoop@ while (restart) {
        lastElement = ""
        restart = false
        for (i in 0..input.size - 1) { // handleplus
            if (input[i] == "+" && lastElement == "+") {
                input.removeAt(i)
                restart = true
                continue@whileLoop
            }
            lastElement = input[i]
        }
        countMinus = 0
        lastElement = ""
        for (i in 0..input.size - 1) { //
            if (input[i] == "-" && lastElement == "-") {
                countMinus++
            }
            if (!(input[i] == "-") && (lastElement == "-") && countMinus > 0) {
                if (countMinus % 2 == 0) {
                    input[i - countMinus - 1] = "-"
                } else {
                    input[i - countMinus - 1] = "+"
                }
                for (j in 0..countMinus - 1) {
                    input.removeAt(i - countMinus)
                }
                restart = true
                continue@whileLoop
            }
            lastElement = input[i]
        }
    }
    return input
}

fun calculateList(input: MutableList<String>): MutableList<String>{
    var partial=multiplyAnddivide(input)
    if (partial.contains("Infinity") || partial.contains("NaN")){
        println("divide by zero error")
    }else{

        var finalSum=addAndSubtract2(partial)
        return finalSum
    }
    return partial
}
fun addAndSubtract2(input: MutableList<String>): MutableList<String>{
    var sum=mutableListOf<String>(input[0])
    //println(input)
    for (i in 0.. input.size-1){
        input[i]= input[i].filter { !it.isWhitespace() }
    }
    //println(input)
    sum[0]= sum[0].filter { !it.isWhitespace() }

    for (i in 0.. input.size-2){
        //println(i)
        //println(input[i+1])
        if (input[i+1]=="+"){

            //println(sum[0])
            //println(input[i+2].toBigInteger())
            input[i]= input[i].filter { !it.isWhitespace() }
            sum[0]= (sum[0].toBigInteger()+input[i+2].toBigInteger()).toString()
        }
        if (input[i+1]=="-"){
            //println(sum[0])
            //println(input[i+2].toBigInteger())

            input[i]= input[i].filter { !it.isWhitespace() }
            sum[0]= (sum[0].toBigInteger() - input[i+2].toBigInteger()).toString()
        }

    }
    return sum
}
fun multiplyAnddivide(input: MutableList<String>): MutableList<String>{
    for (i in 0.. input.size-1){
        input[i]= input[i].filter { !it.isWhitespace() }
    }
    var processingList=input
    var loopTrue=false
    if (processingList.contains("*")){loopTrue =true}
    while(loopTrue){
        loopTrue=false
        processingList =multiplyOne(processingList)
        if (processingList.contains("*")){loopTrue =true}
    }

    loopTrue=false
    if (processingList.contains("/")){loopTrue =true}
    while(loopTrue){
        loopTrue=false
        processingList =divideOne(processingList)
        if (processingList.contains("/")){loopTrue =true}
    }
    return processingList
}
fun multiplyOne(input: MutableList<String>): MutableList<String>{
    var returnList= mutableListOf<String>()
    for (i in 0..input.size-2){
        if (input[i+1]=="*"){
            returnList.add((input[i].toBigInteger() * input[i+2].toBigInteger()).toString())
            returnList.addAll(input.subList(i+3,input.size))
            return returnList
            break
        } else {
            returnList.add( input[i] )
        }
    }
    return returnList
}
fun divideOne(input: MutableList<String>): MutableList<String>{ //may return list with Nan or Infinity
    var returnList= mutableListOf<String>()
    for (i in 0..input.size-2){
        if (input[i+1]=="/"){
            returnList.add((input[i].toBigInteger() / input[i+2].toBigInteger()).toString())
            returnList.addAll(input.subList(i+3,input.size))
            //println(returnList)
            return returnList
            break
        } else {
            returnList.add( input[i] )
        }
    }
    return returnList
}
fun removeSlice(list: MutableList<String>, from: Int, end: Int) {
    for (i in end downTo from) {
        list.removeAt(i)
    }
}
fun parenthesisSeparateInputList(input: MutableList<String>):MutableList<String> {
    var lastParenthesis=" "
    var lastParenthesisIndex=0
    var alteringList: MutableList<String> = ArrayList(input)
    var inputClone: MutableList<String> = ArrayList(input)
    var subinput= mutableListOf<String>()
    var indexRangeStart=0
    var indexRangeStop=0

    forLoop@for (i in 0..inputClone.size-1){ // separate parentesis sequences . do before processing
        if (  inputClone[i] == "(" ){
            lastParenthesisIndex=i
            lastParenthesis=inputClone[i].toString()
        }else if( inputClone[i] ==")"){
            if (lastParenthesis=="("){
                indexRangeStart=lastParenthesisIndex
                indexRangeStop=i

                break@forLoop
            }
            lastParenthesisIndex=i
        }
    }
    subinput=input.subList(indexRangeStart+1,indexRangeStop)
    removeSlice(alteringList,indexRangeStart,indexRangeStop)
    alteringList.add(indexRangeStart,calculateList(subinput)[0])
    return alteringList
}