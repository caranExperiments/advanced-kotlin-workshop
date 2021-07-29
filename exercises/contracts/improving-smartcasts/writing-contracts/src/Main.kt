import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
fun Any?.isNull(): Boolean {
    contract {
        returns(false) implies (this@isNull != null)
    }
    return this == null
}

fun main() {
    val name: String? = "Kotlin"
    if (name.isNull()) return

    println("name is ${name.length} characters long")
}