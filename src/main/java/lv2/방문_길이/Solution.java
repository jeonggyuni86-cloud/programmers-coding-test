package lv2.방문_길이;

import java.util.HashSet;

class Solution {

    private static final int BIAS = 0b101;
    private static final int SHIFT = 0b100;
    private static final int MASK = (1 << SHIFT) + ~0;

    public int solution(String dirs) {
        return getFirstMovement(dirs);
    }


    private int getFirstMovement(String dirs) {
        final var visited = new HashSet<Integer>();
        int curR = 0, curC = 0;

        for(char c : dirs.toCharArray()) {
            int nr = curR, nc = curC;
            switch(c) {
                case 'U' -> nr--;
                case 'D' -> nr++;
                case 'L' -> nc--;
                case 'R' -> nc++;
                default -> throw new IllegalArgumentException();
            }

            if(!canMove(nr, nc)) continue;
            visited.add(
                    Math.min(
                            pack(curR, curC, nr, nc),
                            pack(nr, nc, curR, curC)
                    )
            );

            curR = nr;
            curC = nc;
        }

        return visited.size();
    }

    private boolean canMove(int nr, int nc) {
        return nr >= ~(BIAS + ~0) && nr <= BIAS && nc >= ~(BIAS + ~0) && nc <= BIAS;
    }

    private int pack(int fromR, int fromC, int toR, int toC) {
        return (((fromR + BIAS) & MASK) << (BIAS | (BIAS << 1)))
                | (((fromC + BIAS) & MASK) << (BIAS << 1))
                | (((toR + BIAS) & MASK) << BIAS)
                | (toC + BIAS);
    }
}