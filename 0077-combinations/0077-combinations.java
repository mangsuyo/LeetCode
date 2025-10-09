class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), answer);
        return answer;
    }

    void backtrack(int n, int k, int start, List<Integer> list, List<List<Integer>> answer){

        if(list.size() == k){
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i <= n; i++){
            list.add(i);
            backtrack(n, k, i + 1, list, answer);
            list.remove(list.size() - 1);
        }
    }
}