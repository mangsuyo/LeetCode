class Solution {
    int n;
    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(amount, 0));
        boolean[] visited = new boolean[amount + 1];

        if(amount == 0) return 0;
        
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int i = 0; i < coins.length; i++){
                int nextAmount = cur.amount - coins[i];
                if(nextAmount > 0 && !visited[nextAmount]){
                    queue.offer(new Pair(nextAmount, cur.count + 1));
                    visited[nextAmount] = true;
                }
                else if(nextAmount == 0){
                    return cur.count + 1;
                }
            }
        }

        return -1;
    }

    class Pair{
        int amount;
        int count;

        public Pair(int amount, int count){
            this.amount = amount;
            this.count = count;
        }
    }
}