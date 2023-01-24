fun findSerialNumberForGame(listGames: List<String>) {
    var input = readln()
    for (game in listGames){
        var gameSplitString = game.split("@")
//        for (i in gameSplitString){
//            println(i)
//        }
        if (input==gameSplitString[0]){
            print("Code for Xbox - ")
            print(gameSplitString[1])
            print(", for PC - ")
            print(gameSplitString[2])
        }
        //println(game)
    }

}