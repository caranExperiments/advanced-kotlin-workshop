import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

sealed class State {
    object Loading: State()
    data class Success(val msg: String): State()
    object Error: State()

    @OptIn(ExperimentalContracts::class)
    fun setup(config: () -> Unit) {
        contract { callsInPlace(config, InvocationKind.EXACTLY_ONCE) }
        config()
    }
}

fun main() {
    val state: State = State.Success("Hello Kotlin!")
    val screenTitle: String

    state.setup {
        screenTitle = if(state is State.Success) state.msg else ""
    }

    println(screenTitle)
}
