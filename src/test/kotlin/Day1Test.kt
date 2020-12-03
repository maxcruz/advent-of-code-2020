import org.junit.Test
import kotlin.test.assertEquals

class Day1Test {

    @Test
    fun baseTestCase() {
        assertEquals(514579, repairReport(testInput()))
    }

    @Test
    fun secondStageTestCase() {
        assertEquals(241861950, repairReportThree(testInput()))
    }

    private fun testInput(): IntArray = intArrayOf(1721, 979, 366, 299, 675, 1456)
}