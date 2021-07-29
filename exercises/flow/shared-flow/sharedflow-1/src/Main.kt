import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

data class Location(val lat: Float, val lon: Float)

interface LocationProvider {
    val lastLocation: Flow<Location?>
}

class LocationManager : LocationProvider {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _lastLocation: MutableSharedFlow<Location?> = MutableSharedFlow()
    override val lastLocation: SharedFlow<Location?> = _lastLocation

    init {
        scope.launch {
            while(true) {
                delay(1000)
                    _lastLocation.emit(Location(Random.nextFloat(), Random.nextFloat()))
            }
        }
    }
}

fun main() = runBlocking {
    val manager = LocationManager()
    delay(2000)

    val task1 = async {
        delay(1000)
        manager.lastLocation.take(5).collect { println("1) $it") }
    }

    val task2 = async {
        manager.lastLocation.take(5).collect { println("2) $it") }
    }

    joinAll(task1, task2)
}
