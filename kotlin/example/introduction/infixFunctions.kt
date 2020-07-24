fun main() {
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    val pair = "Ferrari" to "Katrina"
    println(pair)

    infix fun String.onto(other: String) = Pair(this, other)
    val myPair = "McLaren" onto "Lucas"
    println(myPair)

    infix fun Int.hoge(i: Int) = i.plus(this)
    println(1 hoge 2)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    val samantha = Person("Samantha")
    sophia likes claudia
    sophia likes samantha

    for (p in sophia.likedPeople) println(p.name)
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) { likedPeople.add(other) }
}
