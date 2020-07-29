fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println("Numbers: $numbers")

    val anyNegative = numbers.any { it < 0 }
    val anyGT6 = numbers.any { it > 6 }

    println("Is there any number less than 0: $anyNegative")
    println("Is there any number greater than 6: $anyGT6")

    val allEven = numbers.all { it % 2 == 0 }

    val allLess6 = numbers.all { it < 6 }

    println("All numbers are even: $allEven")
    println("All numbers are less than 6: $allLess6")

    val allEvenNone = numbers.none { it % 2 == 1 }

    val allLess6None = numbers.none { it > 6 }

    println("All numbers are even: $allEvenNone")
    println("No element greater than 6: $allLess6None")
}
