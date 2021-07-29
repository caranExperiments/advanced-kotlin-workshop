fun Any?.isNull(): Boolean = this == null

fun main() {
    val name: String? = "Kotlin"
    if (name.isNull()) return

    println("name is ${name?.length} characters long")
}
