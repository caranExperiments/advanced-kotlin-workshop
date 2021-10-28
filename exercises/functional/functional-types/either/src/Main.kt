import arrow.core.Either
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

suspend fun calculateSomeValue(): Either<String, Int> {
    delay(1000)
    return when (val num = Random.nextInt().mod(10)) {
        in 0..5 -> Either.Right(num)
        else -> Either.Left("Value was too big")
    }
}

fun main() = runBlocking {
    when(val result = calculateSomeValue()) {
        is Either.Left -> println("error: ${result.value}")
        is Either.Right -> println("success: ${result.value}")
    }
}
