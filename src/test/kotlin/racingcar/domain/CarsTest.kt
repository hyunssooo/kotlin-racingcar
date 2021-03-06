package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class CarsTest {

    @Test
    fun `elements numbers 사이즈가 다를 경우`() {
        val car1 = Car()
        val car2 = Car()
        assertThrows<IllegalArgumentException> { Cars(arrayListOf(car1, car2)).move(arrayListOf()) }
    }

    @Test
    fun `elements numbers 사이즈가 같을 경우`() {
        val car1 = Car()
        val car2 = Car()
        assertDoesNotThrow { Cars(arrayListOf(car1, car2)).move(arrayListOf(Number(), Number())) }
    }

    @Test
    fun `움직이지 않는 경우`() {
        val car1 = Car()
        val car2 = Car()
        val cars = Cars(arrayListOf(car1, car2))
        val movedCars = cars.move(arrayListOf(Number(3), Number(3)))
        assertThat(cars).isEqualTo(movedCars)
    }

    @Test
    fun `움직이는 경우`() {
        val car1 = Car()
        val car2 = Car()
        val cars = Cars(arrayListOf(car1, car2))
        val movedCars = cars.move(arrayListOf(Number(4), Number(4)))
        assertThat(cars).isNotEqualTo(movedCars)
    }
}
