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
    val input = readInput("Day1Input.txt").map { Integer.parseInt(it) }.toIntArray()

    println("Day 1: Report Repair")
    val answer = repairReport(input)
    println("Answer: $answer")
    println("Day 1: Report Repair. Part Two")
    val answer2 = repairReportThree(input)
    println("Answer: $answer2")
}
