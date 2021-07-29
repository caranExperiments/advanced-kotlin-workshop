import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Start counting")
    countToN(3)
    println("Done counting")
}

/**
 * Update [countToN] so it sequentially prints out all numbers from 0 to [n]
 */
suspend fun countToN(n: Int) = coroutineScope {
    for (i in 0..n) {
        delay(i * 1000L)
        println(i)
    }
}