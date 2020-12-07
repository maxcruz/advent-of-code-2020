
import java.util.*
import kotlin.math.exp

/*
--- Day 5: Binary Boarding ---

You board your plane only to discover a new problem: you dropped your boarding pass! You aren't sure which seat is yours, and all of the flight attendants are busy with the flood of people that suddenly made it through passport control.

You write a quick program to use your phone's camera to scan all of the nearby boarding passes (your puzzle input); perhaps you can find your seat through process of elimination.

Instead of zones or groups, this airline uses binary space partitioning to seat people. A seat might be specified like FBFBBFFRLR, where F means "front", B means "back", L means "left", and R means "right".

The first 7 characters will either be F or B; these specify exactly one of the 128 rows on the plane (numbered 0 through 127). Each letter tells you which half of a region the given seat is in. Start with the whole list of rows; the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). The next letter indicates which half of that region the seat is in, and so on until you're left with exactly one row.

For example, consider just the first seven characters of FBFBBFFRLR:

    Start by considering the whole range, rows 0 through 127.
    F means to take the lower half, keeping rows 0 through 63.
    B means to take the upper half, keeping rows 32 through 63.
    F means to take the lower half, keeping rows 32 through 47.
    B means to take the upper half, keeping rows 40 through 47.
    B keeps rows 44 through 47.
    F keeps rows 44 through 45.
    The final F keeps the lower of the two, row 44.

The last three characters will be either L or R; these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). The same process as above proceeds again, this time with only three steps. L means to keep the lower half, while R means to keep the upper half.

For example, consider just the last 3 characters of FBFBBFFRLR:

    Start by considering the whole range, columns 0 through 7.
    R means to take the upper half, keeping columns 4 through 7.
    L means to take the lower half, keeping columns 4 through 5.
    The final R keeps the upper of the two, column 5.

So, decoding FBFBBFFRLR reveals that it is the seat at row 44, column 5.

Every seat also has a unique seat ID: multiply the row by 8, then add the column. In this example, the seat has ID 44 * 8 + 5 = 357.

Here are some other boarding passes:

    BFFFBBFRRR: row 70, column 7, seat ID 567.
    FFFBBBFRRR: row 14, column 7, seat ID 119.
    BBFFBBFRLL: row 102, column 4, seat ID 820.

As a sanity check, look through your list of boarding passes. What is the highest seat ID on a boarding pass?

 */

fun binarySearch(range: IntRange, moves: Deque<Boolean>): Int {
    if (range.count() == 1) return range.first
    val middle = (range.first + range.last) / 2
    return if (moves.poll()) {
        binarySearch((middle + 1)..range.last, moves)
    } else {
        binarySearch(range.first..middle, moves)
    }
}

private data class SeatCoordinate(val row: ArrayDeque<Boolean>, val column: ArrayDeque<Boolean>)

private fun parseSeatCoordinates(input: String): SeatCoordinate? {
    val row = input.substring(0..6)
        .map { if (it == 'B') true else if (it == 'F') false else return null }
    val column = input.substring(7..9)
        .map { if (it == 'R') true else if (it == 'L') false else return null }
    return SeatCoordinate(row = ArrayDeque(row), column = ArrayDeque(column))
}

fun searchSeatId(input: String): Int {
    val seatCoordinate = parseSeatCoordinates(input) ?: throw IllegalArgumentException()
    val row = binarySearch(0..127, seatCoordinate.row)
    val column = binarySearch(0..7, seatCoordinate.column)
    return row * 8 + column
}

fun maxSeatId(list: List<String>): Int = list.map(::searchSeatId).maxOrNull() ?: throw IllegalStateException()

/*
--- Part Two ---

Ding! The "fasten seat belt" signs have turned on. Time to find your seat.

It's a completely full flight, so your seat should be the only missing boarding pass in your list. However, there's a catch: some of the seats at the very front and back of the plane don't exist on this aircraft, so they'll be missing from your list as well.

Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.

What is the ID of your seat?

 */

fun missingSeatId(list: List<String>): Int {
    val seats = list.map(::searchSeatId).sorted()
    // Gauss sum formula: https://brilliant.org/wiki/sum-of-n-n2-or-n3/#sum-of-the-first-n-positive-integers
    val expected = (seats.last() * (seats.last() + 1)) / 2
    val startMissingSeats = (0 until seats.first()).reduce { acc, i -> acc + i }
    val total = seats.reduce { acc, i -> acc + i } + startMissingSeats
    return expected - total
}

fun main() {
    val input = readInput("Day5Input.txt").lines()

    println("Day 5: Binary Boarding")
    val result = maxSeatId(input)
    println("Answer: $result")
    println("Day 5: Binary Boarding. Part Two")
    val result2 = missingSeatId(input)
    println("Answer: $result2")
}