//find the hex string from the arr. 
//Check every 4 bits from the last by anding with all 1111(15)
public String toHex(int num) {
        if(num == 0) return "0";
        String[] arr = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
        String res = "";
        while(num != 0){
            res = arr[(num & 15)] + res;
            num = (num >>> 4);
        }
        return res;
    }