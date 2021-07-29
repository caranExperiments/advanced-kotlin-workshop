import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Starting to count...")

    launch {
        for (i in 0..3) {
            launch {
                delay(1000L * i)
                println(i)
            }
        }
    }

    println("Done counting")
}
