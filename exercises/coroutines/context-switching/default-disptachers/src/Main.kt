import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    launch {
        println("launch(){} - thread name = ${Thread.currentThread().name}")
    }

    launch(Dispatchers.Default) {
        println("launch(Default){} - thread name = ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("launch(IO){} - thread name = ${Thread.currentThread().name}")
    }

    launch(newSingleThreadContext("CustomThread")) {
        println("launch(newSingleThreadContext()){} - thread name = ${Thread.currentThread().name}")
    }
}
