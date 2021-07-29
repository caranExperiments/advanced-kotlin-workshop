import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

suspend fun helloWorld() {
    println("Hello World!")
}

fun main() {
    GlobalScope.launch { helloWorld() }
}
