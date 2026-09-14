package lv4.호텔방_배정

class Solution {
    fun solution(k: Long, room_number: LongArray): LongArray {
        val hotel = mutableMapOf<Long, Long>()

        return room_number
            .map { find(it, hotel) }
            .toLongArray()
    }

    private fun find(want: Long, hotel: MutableMap<Long, Long>): Long {
        if (want !in hotel) {
            hotel[want] = want + 1
            return want
        }

        val next = find(hotel[want]!!, hotel)
        hotel[want] = next + 1

        return next
    }
}