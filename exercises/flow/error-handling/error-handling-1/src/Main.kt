import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val languages:List<String?> = listOf("Kotlin", "Java", null, "C++", "Dart", "Go")

suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        if(it == null) throw IllegalStateException()
        delay(1000)
        emit(it)
    }
}

fun main() = runBlocking {
    getProgrammingLanguages()
        .catch { error -> emit("") }
        .collect { println(it) }
}
