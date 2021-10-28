import arrow.core.Either
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

suspend fun calculateSomeValue(): Result<Int> {
    delay(1000)
    return when (val num = Random.nextInt().mod(10)) {
        in 0..5 -> Result.success(num)
        else -> Result.failure(IllegalStateException("Value was too big"))
    }
}

fun main() = runBlocking {
    calculateSomeValue().fold(
        onSuccess = { value -> println("success: $value") },
        onFailure = { error -> println("error: $error") }
    )
}
