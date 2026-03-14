class Solution {
    int n;
    public int coinChange(int[] coins, int amount) {
        this.n = coins.length;
        Queue<Coin> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        queue.offer(new Coin(amount, 0));
        visited[amount] = true;

        while(!queue.isEmpty()){
            Coin cur = queue.poll();
            if(cur.amount == 0) return cur.count;
            for(int i = 0; i < n; i++){
                int next = cur.amount - coins[i];
                if(next >= 0 && !visited[next]){
                    queue.offer(new Coin(next, cur.count + 1));
                    visited[next] = true;
                }
            }
        }
        return -1;

    }

    class Coin{
        int amount;
        int count;

        Coin(int amount, int count){
            this.amount = amount;
            this.count = count;
        }
    }
}