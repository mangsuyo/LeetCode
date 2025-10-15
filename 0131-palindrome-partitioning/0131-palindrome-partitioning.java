class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();

        backtrack(s, 0, answer, new ArrayList<>());
        return answer;
    }


    void backtrack(String s, int start, List<List<String>> answer, List<String> list){
        
        if(start == s.length()){
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < s.length(); i++){
            String sub = s.substring(start, i + 1);
            if(isPalindrome(sub)){
                list.add(sub);
                backtrack(s, i + 1, answer, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String sub){
        int left = 0;
        int right = sub.length() - 1;
        
        while(left < right){
            if(sub.charAt(left) != sub.charAt(right)){ return false;
            }
            else{
                left += 1;
                right -= 1;
            }
        }

        return true;

    }
}