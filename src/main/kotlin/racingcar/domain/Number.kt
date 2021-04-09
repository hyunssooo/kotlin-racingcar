package racingcar.domain

class Number private constructor(
    val value: Int = MINIMUM_VALUE
) : Comparable<Number> {

    init {
        require(value in VALUE_RANGE)
    }

    override fun compareTo(other: Number): Int {
        return this.value.compareTo(other.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Number) return false

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    override fun toString(): String {
        return "Number(value=$value)"
    }

    companion object {
        private const val MINIMUM_VALUE = 0
        private const val MAXIMUM_VALUE = 9
        private val VALUE_RANGE = (MINIMUM_VALUE..MAXIMUM_VALUE)
        private val NUMBERS = VALUE_RANGE
            .map { Number(it) }

        fun from(value: Int): Number {
            require(value in VALUE_RANGE) { "지원하지 않는 숫자" }
            return NUMBERS[value]
        }

        fun random() = NUMBERS[VALUE_RANGE.random()]
    }
}
