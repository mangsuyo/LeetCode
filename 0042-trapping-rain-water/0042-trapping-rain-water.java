class Solution {

    int n;

    class Pair{
        int height;
        int index;

        public Pair(int height, int index){
            this.height = height;
            this.index = index;
        }
    }

    public int trap(int[] height) {
        Deque<Pair> stack = new ArrayDeque<>();
        this.n = height.length;
        int[] water = Arrays.copyOf(height, n);

        for(int i = 0; i < n; i++){
            int h = height[i];
            if(h > 0){
                while(!stack.isEmpty() && stack.peek().height <= h){
                    Pair pair = stack.pop();
                    for(int j = pair.index + 1; j < i; j++){
                        water[j] = pair.height;
                    }
                }
                stack.push(new Pair(h, i));
            }
        }

        while(!stack.isEmpty()){
            Pair right = stack.pop();
            if(!stack.isEmpty()){
                Pair left = stack.peek();

                if(left.height > right.height){
                    for(int i = left.index + 1; i < right.index; i++){
                        water[i] = right.height;
                    }
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < n; i++){
            answer += (water[i] - height[i]);
        }

        return answer;
    }
}