/*
--- Day 1: Report Repair ---

After saving Christmas five years in a row, you've decided to take a vacation at a nice resort on a tropical island. Surely, Christmas will go on without you.

The tropical island has its own currency and is entirely cash-only. The gold coins used there have a little picture of a starfish; the locals just call them stars. None of the currency exchanges seem to have heard of them, but somehow, you'll need to find fifty of these coins by the time you arrive so you can pay the deposit on your room.

To save your vacation, you need to get all fifty stars by December 25th.

Collect stars by solving puzzles. Two puzzles will be made available on each day in the Advent calendar; the second puzzle is unlocked when you complete the first. Each puzzle grants one star. Good luck!

Before you leave, the Elves in accounting just need you to fix your expense report (your puzzle input); apparently, something isn't quite adding up.

Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456

In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.

Of course, your expense report is much larger. Find the two entries that sum to 2020; what do you get if you multiply them together?
 */

// O(n) because we need extra space for the map
// O(n) in time complexity to iterate the list, the access to the map is constant time O(1)
fun repairReport(list: IntArray): Int {
    val target = 2020

    // Put the values in a map
    val map = list.mapIndexed { i, it -> it to i }.toMap()

    // Iterate the values
    for (n in list) {
        val candidate = target - n

        // Search the candidate in the map
        if (map.contains(candidate)) return candidate * n
    }
    return -1
}

/*
--- Part Two ---

The Elves in accounting are thankful for your help; one of them even offers you a starfish coin they had left over from a past vacation. They offer you a second one if you can find three numbers in your expense report that meet the same criteria.

Using the above example again, the three entries that sum to 2020 are 979, 366, and 675. Multiplying them together produces the answer, 241861950.

In your expense report, what is the product of the three entries that sum to 2020?

 */

// O(1) because we don't need extra space
// O(n^2) in time complexity because we will need iterate a loop inside another
fun repairReportThree(list: IntArray): Int {
    val target = 2020

    // Sort in place
    list.sort()

    // First iteration discarding the last two elements
    for (i in 0 until list.size - 2) {

        // Iterate with two pointers moving to the center
        var left = i + 1
        var right = list.size - 1
        while (left < right) {

            // Calculate the candidate
            val candidate = list[i] + list[left] + list[right]

            // Move the right pointer if the value is higher, the left if it's lower or return if is equal
            when {
                (candidate > target) -> right--
                (candidate < target) -> left++
                else -> return list[i] * list[left] * list[right]
            }
        }
    }
    return -1
}

fun main() {
    println("Day 1: Report Repair")
    val answer = repairReport(readInput())
    println("Answer: $answer")
    println("Day 1: Report Repair. Part Two")
    val answer2 = repairReportThree(readInput())
    println("Answer: $answer2")
}

fun readInput(): IntArray = intArrayOf(
    1895,
    1732,
    1660,
    1658,
    1878,
    367,
    2010,
    1989,
    431,
    1946,
    1614,
    2003,
    945,
    1856,
    1934,
    1937,
    1781,
    1947,
    1991,
    1917,
    1604,
    1707,
    1966,
    1959,
    1182,
    1828,
    1880,
    1908,
    1942,
    1687,
    1611,
    1922,
    1913,
    1803,
    1976,
    1718,
    1885,
    1971,
    2000,
    1912,
    1981,
    1776,
    1901,
    1941,
    1935,
    1977,
    1907,
    1893,
    1898,
    1975,
    2001,
    1833,
    1951,
    1939,
    1988,
    1870,
    1985,
    1932,
    1930,
    1938,
    1926,
    1931,
    1982,
    76,
    1979,
    657,
    1872,
    1933,
    1961,
    1987,
    1998,
    1994,
    418,
    1914,
    1929,
    1810,
    2009,
    1712,
    830,
    1990,
    1900,
    1876,
    1753,
    1859,
    1965,
    1963,
    1905,
    1921,
    1685,
    1694,
    697,
    1899,
    1997,
    1964,
    1927,
    1952,
    1894,
    1960,
    1986,
    1883,
    1616,
    1993,
    1892,
    1943,
    2005,
    1995,
    1915,
    1663,
    1954,
    1902,
    1191,
    1948,
    1875,
    1850,
    1955,
    1962,
    1984,
    1957,
    1969,
    1887,
    1953,
    1786,
    1638,
    1909,
    1881,
    603,
    1973,
    1784,
    1869,
    1925,
    1968,
    1737,
    1807,
    1950,
    1992,
    1936,
    1918,
    1891,
    1897,
    1940,
    1919,
    1910,
    1862,
    1958,
    1832,
    1904,
    1791,
    1920,
    1874,
    1729,
    1643,
    2007,
    1871,
    1999,
    1584,
    1890,
    1924,
    1974,
    1701,
    1906,
    143,
    1725,
    1945,
    1783,
    1873,
    1903,
    167,
    1855,
    1633,
    1956,
    1996,
    1808,
    1884,
    1916,
    829,
    2002,
    1852,
    1835,
    1889,
    1983,
    1949,
    1970,
    1774,
    1764,
    1609,
    1882,
    1857,
    2004,
    1911,
    1896,
    1980,
    2006,
    1967,
    2008,
    1972,
    1648,
    1923,
    1978,
    1675,
    1831,
)