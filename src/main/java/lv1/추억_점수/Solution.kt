package lv1.추억_점수

class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        val yearningMap = createYearningMap(name, yearning)
        val answer = IntArray(photo.size)

        for (i in photo.indices) {
            var score = 0
            for (target in photo[i]) {
                score += yearningMap[target] ?: 0
            }
            answer[i] = score
        }
        return answer
    }

    private fun createYearningMap(name: Array<String>, yearning: IntArray): Map<String, Int> {
        val map = mutableMapOf<String, Int>()
        for (i in name.indices) {
            map[name[i]] = yearning[i]
        }
        return map
    }
}