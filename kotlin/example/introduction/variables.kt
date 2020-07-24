fun main() {
    var a: String = "inital"
    println(a)
    val b: Int = 1
    println(b)
    val c = 3
    println(c)

    // variable 'e' must be initialized
    // var e: Int
    // println(e)

    val d: Int
    if (someCondition()) {
        d = 1
    } else {
        d = 2
    }

    println(d)
}

fun someCondition() = true
