package lv1.신고_결과_받기

class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val mailMap = createMailMap(createReportMap(report), k)

        return id_list.map { mailMap.getOrDefault(it, 0) }.toIntArray()
    }

    private fun createReportMap(reports: Array<String>): Map<String, Set<String>> {
        val map = mutableMapOf<String, MutableSet<String>>()

        for (report in reports) {
            val split = report.split(" ")
            map.getOrPut(split[1]) { mutableSetOf() }.add(split[0])
        }

        return map
    }

    private fun createMailMap(reports: Map<String, Set<String>>, k: Int): Map<String, Int> {
        val map = mutableMapOf<String, Int>()

        for (value in reports.values) {
            if (value.size < k) continue
            for (name in value) map[name] = (map[name]?: 0) + 1
        }

        return map
    }
}