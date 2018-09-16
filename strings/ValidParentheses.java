//this solution uses stack and nullifies the pairs as it comes
public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
                else if(s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
                else if(s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
                else{stack.push(s.charAt(i));}
            }
        }
        return stack.isEmpty();
    }