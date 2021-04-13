package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.movestrategy.FakeMoveStrategy
import racingcar.domain.movestrategy.FakeNotMoveStrategy

internal class CarTest {

    @Test
    fun `같은 거리인지 체크 같은 거리일 경우`() {
        val car = Car(Name("test"))

        assertThat(car.isSameDistance(Distance(0))).isTrue()
    }

    @Test
    fun `같은 거리인지 체크 다른 거리일 경우`() {
        val car = Car(Name("test"), Distance(1))

        assertThat(car.isSameDistance(Distance(2))).isFalse()
    }

    @Test
    fun `이동이 가능한 경우 거리가 바뀐다`() {
        val car = Car(Name("test"), Distance((1)))
        val movedCar = car.move(FakeMoveStrategy())

        assertThat(movedCar.distance).isEqualTo(Distance(2))
    }

    @Test
    fun `이동이 불가능한 경우 거리가 바뀌지 않는다`() {
        val car = Car(Name("test"), Distance((1)))
        val movedCar = car.move(FakeNotMoveStrategy())

        assertThat(movedCar.distance).isEqualTo(car.distance)
    }
}
