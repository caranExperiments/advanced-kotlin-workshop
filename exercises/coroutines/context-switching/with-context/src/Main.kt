import kotlinx.coroutines.*

private val context = newSingleThreadContext("Custom Context")

suspend fun updateUI(name: String) = withContext(context) {
    println("updateUI() running on: ${Thread.currentThread().name}")
    // do something with value
}

suspend fun longRunningTask() = withContext(Dispatchers.IO) {
    println("longRunningTask() running on: ${Thread.currentThread().name}")
    delay(2000)
    updateUI("Kotlin")
}

fun main(): Unit  = runBlocking(context) {
    println("main() running on: ${Thread.currentThread().name}")
    longRunningTask()
}
