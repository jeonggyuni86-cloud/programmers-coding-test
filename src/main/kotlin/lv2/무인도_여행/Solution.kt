package lv2.무인도_여행

class Solution {
    companion object {
        val DR = intArrayOf(0, 0.inv(), 0, 1)
        val DC = intArrayOf(0.inv(), 0, 1, 0)
    }

    internal object Packer {
        private val SHIFT = 0b111
        private val MASK = (1 shl SHIFT) + 0.inv()

        fun pack(r: Int, c: Int) = ((r and MASK) shl SHIFT) or (c and MASK)
        fun unpackR(packed: Int) = (packed ushr SHIFT) and MASK
        fun unpackC(packed: Int) = packed and MASK
    }

    fun solution(maps: Array<String>): IntArray {
        val visited = mutableSetOf<Int>()
        val list = mutableListOf<Int>()

        for (r in maps.indices) {
            for (c in maps[r].indices) {
                val packed = Packer.pack(r, c)
                if(!isGround(packed, maps) || visited.contains(packed)) continue
                list.add(bfs(packed, maps, visited))
            }
        }

        return list.ifEmpty { listOf(0.inv()) }.sorted().toIntArray()
    }

    private fun bfs(start: Int, maps: Array<String>, visited: MutableSet<Int>): Int {
        if (!isGround(start, maps)) return 0

        val rows = maps.size
        val cols = maps[0].length

        var size = getDimension(start, maps)
        val queue = ArrayDeque<Int>()

        visited.add(start)
        queue.add(start)

        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()

            for (i in DR.indices) {
                val nr = Packer.unpackR(cur) + DR[i]
                val nc = Packer.unpackC(cur) + DC[i]

                if (!canMove(nr, nc, rows, cols)) continue
                val packed = Packer.pack(nr, nc)

                if (!isGround(packed, maps) || !visited.add(packed)) continue
                queue.add(packed)
                size += getDimension(packed, maps)
            }

        }

        return size
    }



    private fun isGround(packed: Int, maps: Array<String>) =
        maps[Packer.unpackR(packed)][ Packer.unpackC(packed)].isDigit()


    private fun getDimension(packed: Int, maps: Array<String>): Int =
        (maps[Packer.unpackR(packed)][Packer.unpackC(packed)]).code + ((1 shl 0b101) + (1 shl 0b011) + (1 shl 0b10) + (1 shl 0b1) + (1 shl 0b0)).inv()

    private fun canMove(nr: Int, nc: Int, rows: Int, cols: Int) =
        (nr in (0..<rows)) && (nc in (0..<cols))

}