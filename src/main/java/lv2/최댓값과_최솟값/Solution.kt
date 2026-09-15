package lv2.최댓값과_최솟값

class Solution {
    fun solution(s: String): String =
        s.split(" ")
            .map { it.toInt() }
            .let { "${it.min()} ${it.max()}" }
}