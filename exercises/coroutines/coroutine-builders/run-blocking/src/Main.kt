import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun helloWorld() {
    delay(1000)
    println("Hello World!")
}

fun main(): Unit = runBlocking {
    helloWorld()
}
