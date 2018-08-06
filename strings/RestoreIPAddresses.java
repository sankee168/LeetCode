//Time complexity: O(n) just because we are using substring other than that everthing is constant because our tree goes max of 4 levels
//Space complexity: O(nm) where m is the count of returned IP List
public List<String> restoreIpAddresses(String s) {
    List<String> list = new ArrayList<>();
    if(s.length() < 4 || s.length() > 12) return list;
    util(list, s, "", 0, 0);
    return list;
}    
private void util(List<String> list, String s, String ans, int index, int dots){
    if(dots > 4) return;
    if(dots == 4 && index == s.length()) {list.add(ans); return;}
    else{
        for(int i = 1; i <= 3; i++){
            if(index+i > s.length()) break;
            String sub = s.substring(index, index+i);
            if((sub.startsWith("0") && sub.length() > 1) || (i == 3 && Integer.parseInt(sub) >= 256)) continue;
            if(dots == 3){
                util(list, s, ans+sub, index+i, dots+1);
            }else util(list, s, ans+sub+".", index+i, dots+1);
        }
    }
}