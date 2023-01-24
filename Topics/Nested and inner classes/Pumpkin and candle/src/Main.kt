class Pumpkin(val type: String, val isForHalloween: Boolean) {

    // create function addCandle()
    val tmp: Candle= Candle()

    fun addCandle(){
        if (isForHalloween){
            tmp.burning()
        }else{
            println("We don't need a candle.")
        }
    }

    inner class Candle {
        fun burning() {
            println("The candle is burning inside this spooky $type pumpkin! Boooooo!")
        }
    }
}