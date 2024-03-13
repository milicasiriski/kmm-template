package com.example.kmmtemplate.util

sealed class Either<out L, out R>(open val value: R?, open val error: L?) {
    abstract val isRight: Boolean
    abstract val isLeft: Boolean

    class Right<out L, out R>(override val value: R) : Either<L, R>(value, null) {
        override val isRight: Boolean
            get() = true
        override val isLeft: Boolean
            get() = false
        override val error get() = null
    }

    class Left<out L, out R>(override val error: L) :
        Either<L, R>(null, error) {
        override val isRight: Boolean
            get() = false
        override val isLeft: Boolean
            get() = true
        override val value get() = null
    }
}

fun <L> L.left(): Either<L, Nothing> = Either.Left(this)

fun <R> R.right(): Either<Nothing, R> = Either.Right(this)