class Solution {
    int n;

    public List<List<String>> groupAnagrams(String[] strs) {
        this.n = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            String cur = strs[i];
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.putIfAbsent(sorted, new ArrayList<>());
            map.get(sorted).add(cur);
        }
        List<List<String>> answer = new ArrayList<>();
        for(List<String> list: map.values()){
            answer.add(list);
        }

        return answer;
    }
}