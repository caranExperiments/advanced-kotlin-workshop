import arrow.core.*
import arrow.core.computations.either
import arrow.typeclasses.Semigroup

/**
 * Enumerate our validation strategies
 */
enum class Strategy {
    FailFast, ErrorAccumulation
}

object Rules {

    private fun EmailField.containsRequired(pattern: String): ValidatedNel<ValidationError, EmailField> {
        return if (value.contains(pattern, false)) {
            validNel()
        } else {
            ValidationError.DoesNotContain(pattern).invalidNel()
        }
    }


    private fun EmailField.isShorterThan(maxLength: Int): ValidatedNel<ValidationError, EmailField> {
        return if (value.length <= maxLength) {
            validNel()
        } else {
            ValidationError.TooLong(maxLength).invalidNel()
        }
    }

    private fun EmailField.validateAccumulateErrors(): ValidatedNel<ValidationError, Email> {
        return containsRequired("@").zip(Semigroup.nonEmptyList(), isShorterThan(250)) { _, _ ->
            Email(value)
        }.handleErrorWith {
            ValidationError.NotAnEmail(it).invalidNel()
        }
    }

    private fun EmailField.validateFailFast(): Either<Nel<ValidationError>, Email> {
        return either.eager {
            containsRequired("@").bind() // fails fast on first error found
            isShorterThan(250).bind()

            // if get to here, we convert into the desired output type
            Email(value)
        }
    }

    operator fun invoke(strategy: Strategy, fields: List<EmailField>): Either<Nel<ValidationError>, List<Email>> =
        when (strategy) {
            Strategy.FailFast -> {
                fields.traverseEither { it.validateFailFast() }
            }
            Strategy.ErrorAccumulation -> {
                fields.traverseValidated(Semigroup.nonEmptyList()) {
                    it.validateAccumulateErrors()
                }.toEither()
            }
        }
}