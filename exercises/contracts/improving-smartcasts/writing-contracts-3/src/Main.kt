import java.lang.IllegalStateException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

sealed class State {
    object Loading: State()
    data class Success(val msg: String): State()
    object Error: State()
}

@OptIn(ExperimentalContracts::class)
fun State?.requireSuccess(): Boolean {
    contract {
        returns() implies(this@requireSuccess is State.Success)
    }
    return if(this is State.Success) true else throw IllegalStateException()
}

fun main() {
    val state: State? = State.Success("success!")

    if(!state.requireSuccess()) return

    println(state.msg)
}
