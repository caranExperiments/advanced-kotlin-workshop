import kotlinx.coroutines.*
import java.util.*

private fun main() = runBlocking {
    println("Starting to count...")

    try {
        withTimeout(2500) { countToN(5) }
    } catch (error: TimeoutCancellationException) {
        println("Timed out after 2500ms")
    }

    println("Done counting")
}

private suspend fun countToN(n: Int) = coroutineScope {
    for (i in 0..n) {
        launch {
            delay(1000L * i)
            println(i)
        }
    }
}
