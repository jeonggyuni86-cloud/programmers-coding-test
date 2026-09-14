package lv1

class Solution {
    fun solution(a: Int, b: Int) = (minOf(a,b) .. maxOf(a,b)).sumOf { it.toLong() }
}