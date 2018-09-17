public int titleToNumber(String s) {
    int val = 0;
    for(int i = 0; i < s.length(); i++){
        val = 26*val + s.charAt(i)-'A'+1;
    }
    return val;
}