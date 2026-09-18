package lv1.비밀_지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        var answer = new String[n];

        for (int r = 0; r < n; r++) {
            var row = new StringBuilder();

            for (int c = n - 1; c >= 0; c--) {
                row.append(
                        ((arr1[r] | arr2[r]) & (1 << c)) != 0
                                ? '#'
                                : ' '
                );
            }

            answer[r] = row.toString();
        }

        return answer;
    }
}