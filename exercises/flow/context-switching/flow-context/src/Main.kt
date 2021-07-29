import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val languages:List<String> = listOf("Kotlin", "Java", "C++", "Dart", "Go")

suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        println("flow $it on thread ${Thread.currentThread().name}")
        delay(1000)
        emit(it)
    }
}

fun main() = runBlocking {
    getProgrammingLanguages()
        .flowOn(Dispatchers.IO)
        .collect {
            println("collect $it on thread ${Thread.currentThread().name}")
        }
}
