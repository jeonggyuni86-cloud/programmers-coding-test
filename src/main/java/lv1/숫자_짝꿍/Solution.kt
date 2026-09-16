package lv1.숫자_짝꿍

import kotlin.math.min

class Solution {
    fun solution(X: String, Y: String): String {
        val sb = StringBuilder()
        for (num in 9 downTo 0) {
            repeat(
                min(
                    X.count { it.digitToInt() == num },
                    Y.count { it.digitToInt() == num }
                )
            ) {
                sb.append(num)
            }

        }

        return if (sb.isEmpty()) "-1" else if (sb[0] == '0') "0" else sb.toString()
    }
}