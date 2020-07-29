fun main() {

    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val first = numbers.first()
    val last = numbers.last()

    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }

    println("Numbers: $numbers")
    println("First $first, last $last, first even $firstEven, last odd $lastOdd")

    val words = listOf("foo", "bar", "baz", "faz")
    val empty = emptyList<String>()

    val firstWord = empty.firstOrNull()
    val lastWord = empty.lastOrNull()

    val firstF = words.firstOrNull { it.startsWith('f') }
    val firstZ = words.firstOrNull { it.startsWith('z') }
    val lastF = words.lastOrNull { it.endsWith('f') }
    val lastZ = words.lastOrNull { it.endsWith('z') }

   println("First $firstWord, last $lastWord")
   println("First starts with 'f' is $firstF, last starts with 'z' is $firstZ")
   println("First ends with 'f' is $lastF, last ends with 'z' is $lastZ")
}
