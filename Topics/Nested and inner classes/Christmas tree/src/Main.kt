class ChristmasTree(var color: String) {

    // create function putTreeTopper()
    fun putTreeTopper(color: String){
        var TT =TreeTopper(color)
        TT.sparkle()
    }
    inner class TreeTopper(private var color: String) {
        // create function sparkle()
        fun sparkle(){
            println("The sparkling ${this@TreeTopper.color} tree topper looks stunning on the ${this@ChristmasTree.color} Christmas tree!")
        }
    }
}
