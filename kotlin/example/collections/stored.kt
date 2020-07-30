fun main() {

    val shuffled = listOf(5, 4, 2, 1, 3)
    val natural = shuffled.sorted()
    val inverted = shuffled.sortedBy { -it }

    println("Shuffled: $shuffled")
    println("Natural order: $natural")
    println("Inverted natural order: $inverted")
}
