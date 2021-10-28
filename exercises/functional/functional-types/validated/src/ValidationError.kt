import arrow.core.Nel

sealed class ValidationError(val msg: String) {
    data class DoesNotContain(val value: String) : ValidationError("Did not contain $value")
    data class TooLong(val value: Int) : ValidationError("Exceeded length of $value")
    data class NotAnEmail(val reasons: Nel<ValidationError>) : ValidationError("Not a valid email")
}