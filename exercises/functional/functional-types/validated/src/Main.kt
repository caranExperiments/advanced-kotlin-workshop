import arrow.core.*

val invalidEmails = listOf(
    EmailField("nowhere.com"),
    EmailField("nowheretoolong${(0..251).map { "g" }}"), //this fails
    EmailField("getlost@nowhere.com")
)

val validEmails = listOf(
    EmailField("kotlin@jetbrains.com"),
    EmailField("kotlin@kotlin.dev"),
)

fun main() {
    when (val result = Rules(Strategy.ErrorAccumulation, invalidEmails)) {
        is Either.Left -> println("error: ${result.value.all}")
        is Either.Right -> println("success: ${result.value}")
    }
}
