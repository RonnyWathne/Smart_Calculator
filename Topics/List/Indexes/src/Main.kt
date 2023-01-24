fun solution(products: List<String>, product: String) {
    // put your code here
    val inicesList = mutableListOf<Int>()
    for (i in products.indices) {
        if (products[i] == product) inicesList.add(i)
    }
    for (i in inicesList){
        print(i)
        print(" ")
    }
}