class Solution {
    int n;
    public int trap(int[] height) {
        this.n = height.length;
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            int h = height[i];
            while(!stack.isEmpty() && height[stack.peek()] <= h){
                int bottom = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int width = i - left - 1;
                int waterH = Math.min(h, height[left]) - height[bottom] ;

                answer += width * waterH;
            }

            stack.push(i);
        }

        return answer;
    }
}