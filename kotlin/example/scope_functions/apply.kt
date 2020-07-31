package example.scope.functions.apply

data class Person(var name: String, var age: Int, var about: String) {
    constructor() : this("", 0, "")
}

fun main() {
    val jake = Person()
    // 戻り値はオブジェクト自体
    val stringDescription = jake.apply {
        name = "Jake"
        age = 30
        about = "Android developer"
    }
    println(stringDescription.toString())
}
