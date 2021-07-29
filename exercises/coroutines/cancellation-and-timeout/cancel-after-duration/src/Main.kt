import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking {
    println("Starting to count...")

    val job = launch { countToN(5) }
    delay(2500)
    job.cancel()
    job.join()

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
