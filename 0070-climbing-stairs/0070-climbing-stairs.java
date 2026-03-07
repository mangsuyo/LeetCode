class Solution {
    Map<Integer, Integer> hash = new HashMap<>();
    public int climbStairs(int n) {
        hash.put(1, 1);
        hash.put(2, 2);
        return dp(n);
    }

    int dp(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(!hash.containsKey(n)){
            hash.put(n, dp(n - 1) + dp(n - 2));
        }
        return hash.get(n);
    }
}