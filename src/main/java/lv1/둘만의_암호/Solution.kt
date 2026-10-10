package lv1.둘만의_암호

class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val chars = (('a'..'z')
            .filter { it !in skip })
            .toList()
            .toCharArray()
        return "a"
    }
}
