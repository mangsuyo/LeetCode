class Solution {
    int n;
    public int trap(int[] height) {
        this.n = height.length;
        int[] waterH = new int[n];

        for(int i = 0; i < n; i++){
            waterH[i] = height[i];
        }
        Deque<Node> stack = new ArrayDeque<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            int idx = i;
            int h = height[i];
            while(!stack.isEmpty() && stack.peek().h <= h){
                Node past = stack.pop();
                for(int j = past.index; j < i; j++){
                    waterH[j] = past.h;
                }
            }
            stack.push(new Node(i, h));   
        }

        while(!stack.isEmpty()){
            Node right = stack.pop();
            if(stack.isEmpty()) break;
            Node left = stack.peek();
            for(int i = left.index + 1; i < right.index; i++){
                waterH[i] = Math.max(waterH[i], right.h);
            }
        }


        for(int i = 0; i < n; i++){
            answer += (waterH[i] - height[i]);
            // System.out.println(waterH[i]);
        }

        return answer;
    }


    class Node{
        int index;
        int h;

        Node(int index, int h){
            this.index = index;
            this.h = h;
        }
    }
}