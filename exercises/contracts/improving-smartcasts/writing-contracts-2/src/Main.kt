import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun String?.isNotNullOrBlank(): Boolean {
    contract {
        returns(true) implies(this@isNotNullOrBlank != null)
    }
    return !isNullOrBlank()
}

fun main() {
    val name: String? = "Kotlin"
    if (name.isNotNullOrBlank()) {
        println("name is ${name.length} characters long")
    }
}