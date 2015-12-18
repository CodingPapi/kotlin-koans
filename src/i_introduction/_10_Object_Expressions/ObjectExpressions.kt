package i_introduction._10_Object_Expressions

import java.util.*
import util.*

fun todoTask10(): Nothing = TODO(
    """
        Task 10.
        Read about object expressions that play the same role in Kotlin as anonymous classes do in Java.

        Add an object expression that provides a comparator to sort a list in a descending order using java.util.Collections class.
        In Kotlin you use Kotlin library extensions instead of java.util.Collections,
        but this example is still a good demonstration of mixing Kotlin and Java code.
    """,
    documentation = doc10()
)

fun task10(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, { t1, t2 -> if(t1 == t2) 0 else if(t1 > t2) -1 else 1 })
    Collections.sort(arrayList, object: Comparator<Int> {
        override fun compare(lhs: Int?, rhs: Int?): Int {
            return if (lhs != null && rhs != null) {
                if (lhs == rhs) 0 else if (lhs > rhs) -1 else 0
            } else {
                throw UnsupportedOperationException()
            }
        }
    })
    return arrayList

}