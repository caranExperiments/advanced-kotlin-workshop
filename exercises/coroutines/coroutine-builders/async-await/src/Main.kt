import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun longRunningTask1(): Int {
    delay(1000)
    return 2
}

suspend fun longRunningTask2(): Int {
    delay(1000)
    return 3
}


fun main() = runBlocking {
    val time = measureTimeMillis {
        val one = longRunningTask1()
        val two = longRunningTask2()
        println("The answer is ${one + two}")
    }
    println("Took $time milliseconds")
}
