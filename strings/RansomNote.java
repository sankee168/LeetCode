//time complexity: O(m+n) where m is the length of ransomNote and n is the length of magazine
//space complexity: O(1) because we are using constant space of 26
//Idea here is simple. Keep incrementing the char count from magazine and decrease the char count in ransomNote. when that goes below 0 that is false
public boolean canConstruct(String ransomNote, String magazine) {
    int[] arr = new int[26];
    for(int i = 0; i < magazine.length(); i++){
        arr[magazine.charAt(i)-'a']++;
    }        
    for(int i = 0; i < ransomNote.length(); i++){
        int index = ransomNote.charAt(i)-'a';
        if(arr[index] == 0) return false;
        arr[index]--;
    }        
    return true;
}