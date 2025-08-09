import java.util.*;

class Solution {

    int n;
    public int trap(int[] height) {
        n = height.length;
        
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        int[] wall = new int[n];
        for(int i = 0; i < n; i++){
            wall[i] = height[i];
        }

        for(int i = 0; i < n; i++){
            if(wall[i] > 0){
                while(!stack.isEmpty() && stack.peek().height <= wall[i]){
                    Pair pair = stack.pop();
                    for(int j = pair.index + 1; j < i; j++){
                        wall[j] = pair.height;
                    }
                }
                stack.push(new Pair(i, wall[i]));
            }   
        }
        int answer = 0;

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            if(stack.isEmpty()) break;
            Pair peek = stack.peek();
            for(int i = peek.index + 1; i < pair.index; i++){
                wall[i] = pair.height;
            }
        }

        for(int i = 0; i < n; i++){
            answer += (wall[i] - height[i]);
        }



        return answer;
    }
}

class Pair{
    int index;
    int height;

    public Pair(int index, int height){
        this.index = index;
        this.height = height;
    }
}