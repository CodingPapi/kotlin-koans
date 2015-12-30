package iii_conventions

import util.*


class Invokable {
    var invocationsCount = 0
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })
operator fun Invokable.invoke(): Invokable {
    invocationsCount++
    return this
}
fun Invokable.getNumberOfInvocations() = this.invocationsCount
fun task31(invokable: Invokable): Int {
//    todoTask31()
    return invokable()()()().getNumberOfInvocations()
}
