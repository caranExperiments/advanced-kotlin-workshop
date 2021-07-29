
fun String?.isNotNullOrBlank() = !isNullOrBlank()

fun main() {
    val name: String? = null
    if (name.isNotNullOrBlank()) {
        println("name is ${name?.length} characters long")
    }
}
