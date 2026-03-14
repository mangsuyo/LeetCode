class Solution {
    int n;
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        this.n = s.length();
        int answer = 0;
        stack.push(-1);
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    answer = Math.max(answer, i - stack.peek());
                }
            }
        }
        return answer;
    }
}