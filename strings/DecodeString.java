//Idea here is to maintian two stacks
//one stack is for repetitions and one for prefix before "["
//when we encounter [ that means current string which is being till current index we push it to stack
//when we encounter ] that reps stack will have number of reps of current string
//after looping we have resolved the inner braces, so we pop the string stack and append the repetitions string
//then continue the process
//Time complexity: O(n)
//Space complexity: O(n)
public String decodeString(String s) {
    Stack<Integer> reps = new Stack<>();        
    Stack<String> resStack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < s.length(); i++){
        if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
            //if stack is empty then append to the output
            sb.append(s.charAt(i));
        }
        else if(s.charAt(i) == '[') {
            resStack.push(sb.toString());
            sb = new StringBuilder();
        }
        else if(s.charAt(i) == ']') {
            int count = reps.pop();
            String result = resStack.pop();
            String temp = sb.toString();
            sb = new StringBuilder(result);
            while(count > 0){
                sb.append(temp);
                count--;
                            
        }else{
            int j = i;
            while(s.charAt(j) >= '0' && s.charAt(j) <= '9') j++;
            int count = Integer.parseInt(s.substring(i, j));
            reps.push(count);
            System.out.println(count);
            i = j-1;
        }
    }
    return sb.toString();
}