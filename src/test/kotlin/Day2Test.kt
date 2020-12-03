import org.junit.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun baseTestCase() {
        assertEquals(true, isSledPasswordValid("1-3 a: abcde"))
        assertEquals(false, isSledPasswordValid("1-3 b: cdefg"))
        assertEquals(true, isSledPasswordValid("2-9 c: ccccccccc"))
    }

    @Test
    fun secondStageTestCase() {
        assertEquals(true, isTobogganPasswordValid("1-3 a: abcde"))
        assertEquals(false, isTobogganPasswordValid("1-3 b: cdefg"))
        assertEquals(false, isTobogganPasswordValid("2-9 c: ccccccccc"))
    }
}