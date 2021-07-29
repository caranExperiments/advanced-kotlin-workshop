import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

suspend fun getProgrammingLanguages(): Flow<String> {
    return listOf("Kotlin", "Java", "C++", "Dart", "Go").asFlow()
}

fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}
