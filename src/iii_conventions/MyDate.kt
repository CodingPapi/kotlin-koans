package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int =
            compareValuesBy(this, other, {it.year}, {it.month}, {it.dayOfMonth})
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return addTimeIntervals(timeInterval, 1)
}

operator fun MyDate.plus(repeatedTimeIntervals: RepeatedTimeIntervals): MyDate {
    return addTimeIntervals(repeatedTimeIntervals.timeInterval, repeatedTimeIntervals.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(times: Int): RepeatedTimeIntervals {
    return RepeatedTimeIntervals(this, times)
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

data class RepeatedTimeIntervals(val timeInterval: TimeInterval, val times: Int) {

}
