class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];
        for(int i = 0; i < strs.length; i++){
            List<String> temp = new ArrayList<>();
            if(!visited[i]){
                temp.add(strs[i]);
                visited[i] = true;
            }
            for(int j = i + 1; j < strs.length; j++){
                if(strs[i].length() != strs[j].length()) continue;
                else{
                    int flag = 1;
                    for(Character c: strs[i].toCharArray()){
                        if(!strs[j].contains(String.valueOf(c))){
                            flag = 0;
                            break;
                        }
                        if(getCount(strs[j], c) != getCount(strs[i], c)){
                            flag = 0;
                            break;
                        }
                    }
                    if(flag == 1 && !visited[j]){
                        temp.add(strs[j]);
                        visited[j] = true;
                    }
                }
            }
            if(!temp.isEmpty()){
                list.add(new ArrayList<>(temp));
            }
        }

        System.out.println(list);
        return list;
    }

    int getCount(String str, Character target){
        int count = 0;
        for(Character c: str.toCharArray()){
            if(c == target){
                count += 1;
            }
        }
        return count;
    }
}