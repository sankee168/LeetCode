//Idea is to compare the counts of chars in words with licenseplate
//at the same time if word has all the required chars, then check for the minLength previously recorded and update
//Time complexity: O(n) where n is the size of words
//Space complexity: O(1)
public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] arr = new int[26];
    int count = 0;
    for(char c : licensePlate.toCharArray()){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            arr[Character.toLowerCase(c)-'a']++;
            count++;
        }
    }        
    int minLength = Integer.MAX_VALUE;
    int index = -1;
    for(int i = 0; i < words.length; i++){
        String curr = words[i];
        int[] temp = new int[26];
        int tempCount = 0;
        for(char c : curr.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                char lCase = Character.toLowerCase(c);
                temp[lCase-'a']++;
                if(temp[lCase-'a'] <= arr[lCase-'a']) tempCount++;
            }
            if(tempCount == count){
                if(minLength > curr.length()){
                    index = i;
                    minLength = curr.length();
                }
                break;
            }
        }
    }
    return words[index];
}

//this is more modularized code
public String shortestCompletingWord(String licensePlate, String[] words) {
    int[] arr = getCount(licensePlate);
    int minLength = Integer.MAX_VALUE;
    String ans = "";
    for(String word: words){
        if(word.length() >= minLength) continue;
        int[] temp = getCount(word);
        if(check(arr, temp) && word.length() < minLength){
            minLength = word.length();
            ans = word;
        } 
    }
    return ans;
}

private boolean check(int[] arr, int[] curr){
    for(int i = 0; i < 26; i++){
        if(arr[i] > curr[i]) return false;
    }
    return true;
}

private int[] getCount(String word){
    int[] arr = new int[26];
    for(char c : word.toCharArray()){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            arr[Character.toLowerCase(c)-'a']++;
        }
    }
    return arr;
}