import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val languages:List<String?> = listOf("Kotlin", "Java", null, "C++", "Dart", "Go")

suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        if(it == null) return@forEach
        delay(1000)
        emit(it)
    }
}

fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}
