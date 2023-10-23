import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcComission_VKPayOverLimit() {
        val cardType = "VK Pay"
        val paymentsSum = 0
        val payment = 80_000

        val result = calcComission(cardType, paymentsSum, payment)

        assertEquals(-1, result)
    }
    @Test
    fun calcComissionMirNormalCalc() {

        val result = calcComission("Мир", 10_000,1_000)
        assertEquals(35, result)
    }

    @Test
    fun calcComissionMaestroNormalCalc() {

        val result = calcComission("Maestro", 60_000,30_000)
        assertEquals(110, result)
    }

    @Test
    fun calcComissionMaestroNormalCalc2() {

        val result = calcComission("Maestro", 80_000,10_000)
        assertEquals(80, result)
    }


    @Test
    fun calcComissionMaestroOverLimit() {

        val result = calcComission("Maestro", 599_000,1_001)
        assertEquals(-1, result)
    }

    @Test
    fun calcComissionVisaOverLimit() {

        val result = calcComission("Visa", 599_000,1_001)
        assertEquals(-1, result)
    }


    @Test
    fun calcComissionVKPayNormal() {

        val result = calcComission("VK Pay", 500,100)
        assertEquals(0, result)
    }

    @Test
    fun calcComissionMaestroNoComission() {

        val result = calcComission("Maestro", 100,5001)
        assertEquals(0, result)
    }

}