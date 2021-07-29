import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Print the following values
 *
 * Kotlin
 * Java
 * C++
 * Dart
 * Go
 *
 */
suspend fun getProgrammingLanguages(): Flow<String>
    = flowOf("Kotlin", "Java", "C++", "Dart", "Go")

fun main() = runBlocking {
    getProgrammingLanguages().collect { println(it) }
}
