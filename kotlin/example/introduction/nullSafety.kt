fun main() {
    var neverNull: String = "This can't be null"
    // neverNull = null

    var nullable: String?
    nullable = "You can keep a null here"
    println(describeString(nullable))

    nullable = null
    println(describeString(nullable))

    var inferredNonNull = "The compiler assumes non-null"
    // inferredNonNull = null

    fun strLength(notNull: String): Int {
        return notNull.length
    }

    strLength(neverNull)
    // strLength(nullable)

    println(describeString(inferredNonNull))
}

fun describeString(maybeString: String?): String {
    if (maybeString != null && maybeString.length > 0) {
        return "String of length ${maybeString.length}"
    } else {
        return "Empty or null string"
    }
}
