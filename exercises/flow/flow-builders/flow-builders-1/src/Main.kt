import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private val languages:List<String> = listOf("Kotlin", "Java", "C++", "Dart", "Go")

suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        delay(1000)
        emit(it)
    }
}

fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}
