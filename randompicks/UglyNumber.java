//As given, we have to check if num is divisible only by 2, 3 and 5. So we keep dividing by each of them till we 
//see somethign which is not divisible by them. if that number is 1, then return true else return false;
//Time complexity: O(logn)
//Space complexity: O(1)
public boolean isUgly(int num) {
    if(num <= 0) return false;
    for(int i = 2; i < 6; i++){
        while(num%i == 0){
            num = num/i;
        }
    }
    if(num==1) return true;
    return false;
}