//Time complexity: O(n)
//Space complexity: O(1)
//We reverse the complete array once and then go over each word and reverse back
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length-1);
        int i = 0, j = 0;
        while(j < str.length){
            while(j < str.length-1 && str[j+1] != ' ') j++;
            reverse(str, i, j);
            j = j+2;
            i = j;
        }
    }
    
    private void reverse(char[] str, int i, int j){
        while(i < j){
            char tmp = str[i];
            str[i] = str[j];
            str[j] =  tmp;
            i++; j--;
        }
    }