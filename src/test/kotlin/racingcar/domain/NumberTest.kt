package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class NumberTest {

    @ParameterizedTest(name = "숫자가 {0}일 경우")
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `생성 정상 범위 0 ~ 9`(value: Int) {
        assertDoesNotThrow { Number(value) }
    }

    @ParameterizedTest(name = "숫자가 {0}일 경우")
    @ValueSource(ints = [-1, 10])
    fun `생성 정상 범위 이외에 0보다 작을 경우, 9보다 클 경우`(value: Int) {
        assertThrows<IllegalArgumentException> { Number(value) }
    }

    @Test
    fun `비교`() {
        val four = Number(4)
        val three = Number(3)
        assertThat(three.isOver(four))
            .isFalse()
        assertThat(four.isOver(four))
            .isTrue()
        assertThat(four.isOver(three))
            .isTrue()
    }
}
