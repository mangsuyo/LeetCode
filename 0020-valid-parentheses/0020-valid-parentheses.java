import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push(')');
			}
			else if(s.charAt(i) == '['){
				stack.push(']');
			}
			else if(s.charAt(i) == '{'){
				stack.push('}');
			}
			else{
				if(stack.isEmpty()){
					return false;
				}
				if(stack.pop() != s.charAt(i)){
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
