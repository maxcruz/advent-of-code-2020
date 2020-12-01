import org.junit.Test
import kotlin.test.assertEquals


class Day1Test {

    @Test
    fun baseTestCase() {
        val input = intArrayOf(1721, 979, 366, 299, 675, 1456)
        val expected = 514579
        val result = repairReport(input)
        assertEquals(expected, result)
    }

    @Test
    fun secondStageTestCase() {
        val input = intArrayOf(1721, 979, 366, 299, 675, 1456)
        val expected = 241861950
        val result = repairReportThree(input)
        assertEquals(expected, result)
    }
}