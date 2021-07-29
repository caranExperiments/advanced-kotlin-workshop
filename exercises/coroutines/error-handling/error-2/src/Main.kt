import kotlinx.coroutines.*
import java.lang.RuntimeException

// Will provide a less noisy error message when an unhandled exception is caught
// within launch{} calls where this is used
val handler = CoroutineExceptionHandler { _, exception ->
    println("Caught $exception")
}

fun main() = runBlocking {
    val scope = CoroutineScope(SupervisorJob())

    val job1 = scope.launch {
        delay(200)
        println(1)
    }
    val job2 = scope.launch {
        delay(100)
        println(2)
    }
    val job3 = scope.launch(handler) { throw RuntimeException() }
    val job4 = scope.launch { println(4) }

    joinAll(job1, job2, job3, job4)
    println("Finished")
}
