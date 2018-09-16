//we can do a linear scan over the letter. first one which is greater is result
public char nextGreatestLetter(char[] letters, char target) {
	int i = 0;
	//we start at n as we have a possible result which might go beyond length
	int j = letter.length;
	while(i < j){
		int mid = (i+j)/2;

		if(letters[mid] > target){
			prev = mid;
			j = mid;
		}else{
			i = mid+1;
		}
	}
	return letters[i%letters.length];
}

//Idea is to keep l as the immediate highest element
//if target is greater or equals then we have to return 0th char
public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return target >= letters[l] ? letters[0] : letters[l];
    }