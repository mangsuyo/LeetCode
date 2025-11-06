class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int start = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            while(set.contains(c)){
                set.remove(s.charAt(start++));
            }
            set.add(c);
            answer = Math.max(answer, set.size());
        }

        return answer;
    }
}