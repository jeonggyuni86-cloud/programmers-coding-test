package lv1.로또의_최고_순위와_최저_순위

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        val set = win_nums.toSet()
        val zero = lottos.count { it == 0 }
        val match = lottos.count { it in set }
        return intArrayOf(getRank(zero + match), getRank(match))
    }

    private fun getRank(match: Int) = if (match == 0) 6 else 7 - match
}