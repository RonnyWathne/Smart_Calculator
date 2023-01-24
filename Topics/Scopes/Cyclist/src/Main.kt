fun main() {
    var distance = readLine()!!.toInt() // the distance back
    var totalDistance = readLine()!!.toInt()
    var delta: Int = distance
    // fix the code below
    if (distance < 0) {
        delta = -distance
    }

    totalDistance += delta
    println(totalDistance)
}