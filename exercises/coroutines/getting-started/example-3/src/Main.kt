import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun helloWorld() {
    delay(1000)
    println("Hello World!")
}

fun main() {
    GlobalScope.launch { helloWorld() }
    Thread.sleep(2000)
}
