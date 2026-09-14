package lv1.두_정수_사이의_합

class Solution {
    fun solution(a: Int, b: Int) = (minOf(a,b) .. maxOf(a,b)).sumOf { it.toLong() }
}