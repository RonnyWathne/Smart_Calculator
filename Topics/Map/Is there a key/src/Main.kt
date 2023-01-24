

fun containsKeyAndValue(map: Map<String, String>, value: String): Boolean {
    // put your code here
    if (map.containsKey(value)&&map.containsValue(value) ){
        return true
    }else{
        return false
    }
}