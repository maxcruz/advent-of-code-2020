import org.junit.Test
import kotlin.test.assertEquals

class Day4Test {

    @Test
    fun baseTestCase() {
        val passport1 = mapOf(
            "ecl" to "gry",
            "pid" to "860033327",
            "eyr" to "2020",
            "hcl" to "#fffffd",
            "byr" to "1937",
            "iyr" to "2017",
            "cid" to "147",
            "hgt" to "183cm",
        )
        val passport2 = mapOf(
            "iyr" to "2013",
            "ecl" to "amb",
            "cid" to "350",
            "eyr" to "#2023",
            "pid" to "028048884",
            "hcl" to "#cfa07d",
            "byr" to "147",
        )
        assertEquals(1, countValidPassports(listOf(passport1)))
        assertEquals(0, countValidPassports(listOf(passport2)))
    }

    @Test
    fun secondStageTestCase() {
        val passport1 = mapOf(
            "eyr" to "1972",
            "cid" to "100",
            "hcl" to "#18171d",
            "ecl" to "amb",
            "hgt" to "170",
            "pid" to "186cm",
            "iyr" to "2018",
            "byr" to "1926"
        )
        val passport2 = mapOf(
            "pid" to "087499704",
            "hgt" to "74in",
            "ecl" to "grn",
            "iyr" to "2012",
            "eyr" to "2030",
            "byr" to "1980",
            "hcl" to "#623a2f",
        )
        assertEquals(0, countValidDataPassports(listOf(passport1)))
        assertEquals(1, countValidDataPassports(listOf(passport2)))
    }
}