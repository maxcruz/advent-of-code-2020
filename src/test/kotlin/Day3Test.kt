import org.junit.Test
import kotlin.test.assertEquals

class Day3Test {

    private fun testLand(): List<String> =
        listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
        )

    @Test
    fun baseTestCase() {
        assertEquals(3, findTrees(testLand()))
    }

    @Test
    fun secondStageTestCase() {
        assertEquals(18, findTreesAlternatives(testLand()))
    }
}