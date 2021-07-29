import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

private val languages:List<String> = listOf(
    "Kotlin",
    "Java",
    "C++",
    "Dart",
    "Javascript",
    "Python",
    "Go"
)

suspend fun getProgrammingLanguages(): Flow<String> = flow {
    languages.forEach {
        delay(1000)
        emit(it)
    }
}

fun main(): Unit = runBlocking {
    getProgrammingLanguages()
        .filter { name -> name.length >= 4 }
        .take(3)
        .collect { println(it) }
}
