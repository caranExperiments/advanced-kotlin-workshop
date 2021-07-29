import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

data class Location(val lat: Float, val lon: Float)

interface LocationProvider {
    val lastLocation: Flow<Location?>
}

class LocationManager : LocationProvider {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val _lastLocation: MutableStateFlow<Location?> = MutableStateFlow(null)
    override val lastLocation: StateFlow<Location?> = _lastLocation

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
    val firstObserver = manager.lastLocation.first()
    val secondObserver = manager.lastLocation.first()

    println(firstObserver == secondObserver)
}
