import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

fun main() = runBlocking {
    coroutineScope {
        launch { println("1") }
        launch { println("2") }
        throw RuntimeException()
    }

    println("Finished")
}
