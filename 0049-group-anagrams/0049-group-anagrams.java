class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hash = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            hash.putIfAbsent(sorted, new ArrayList<>());
            hash.get(sorted).add(str);
        }

        return new ArrayList<>(hash.values());
    }
}