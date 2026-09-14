package lv2.올바른_괄호;

class Solution {
    boolean solution(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            if(c == '(') count++;
            else count--;
            if(count < 0) return false;
        }
        return count == 0;
    }
}