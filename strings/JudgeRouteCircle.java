//Time complexity: O(n)
//Space complexity: O(n) where n is the size of the string
public boolean judgeCircle(String moves) {
	char[] arr = moves.toCharArray();
	int i = 0; int j = 0;
	for(char curr : arr){
		if(curr == 'U'){
			j++;
		}else if(curr == 'D'){
			j--;
		}else if(curr == 'L'){
			i--;
		}else if(curr == 'R'){
			i++;
		}		
	}
        
    if(i == 0 && j == 0) return true;
    return false;
}