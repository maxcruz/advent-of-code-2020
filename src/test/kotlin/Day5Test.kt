import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class Day5Test {

    @Test
    fun testBinarySearch() {
        val queue1 = ArrayDeque(listOf(false, true, false, true, false, true, false))
        assertEquals(35, binarySearch(1..100, queue1))
        val queue2 = ArrayDeque(listOf(false, true, false))
        assertEquals(3, binarySearch(1..8, queue2))
    }

    @Test
    fun baseTestCase() {
        assertEquals(567, searchSeatId("BFFFBBFRRR"))
        assertEquals(119, searchSeatId("FFFBBBFRRR"))
        assertEquals(820, searchSeatId("BBFFBBFRLL"))
    }
}