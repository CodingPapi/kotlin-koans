package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
            compareValuesBy(this, other, {it.year}, {it.month}, {it.dayOfMonth})
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate): ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate>  = object : Iterator<MyDate> {
        var temp = start
        override fun next(): MyDate {
            try {
                return temp
            } finally {
                temp = temp.nextDay()
            }

        }

        override fun hasNext(): Boolean {
            return temp <= endInclusive
        }
    }

}
