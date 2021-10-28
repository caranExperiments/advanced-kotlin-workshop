import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

suspend fun calculateSomeValue(): Option<Int> {
    delay(1000)
    return when (val num = Random.nextInt().mod(10)) {
        in 0..5 -> Some(num)
        else -> None
    }
}

fun main() = runBlocking {
    when(val result = calculateSomeValue()) {
        is None -> println("value was too large")
        is Some -> println("success: ${result.value}")
    }
}
