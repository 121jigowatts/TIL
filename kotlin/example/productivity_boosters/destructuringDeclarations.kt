package example.productivity.boosters

fun findMinMax(list: List<Int>): Pair<Int, Int> {
    for (l in list) {
        // do the math
    }
    return Pair(50, 100)
}

data class User(val username: String, val email: String)

fun getUser() = User("Mary", "mary@somewhere.com")

class Pair<K, V>(val first: K, val second: V) {
    operator fun component1(): K {
        return first
    }

    operator fun component2(): V {
        return second
    }
}

fun main() {
    val (x, y, z) = arrayOf(5, 10, 15)
    println("$x $y $z")

    val map = mapOf("Alice" to 21, "Bob" to 25)
    for ((name, age) in map) {
        println("$name is $age years old")
    }

    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))
    println("Min:$min, Max:$max")

    val user = getUser()
    val (username, email) = user
    println(username == user.component1())
    println(email)

    val (_, emailAddress) = getUser()
    println(emailAddress)

    val (num, name) = Pair(1, "one")

    println("num = $num, name = $name")
}
