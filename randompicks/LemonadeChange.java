//just manupulating the elements in the array
//As there are three bills we can easily write this by swicth case
//simple if else block will also work
//Time complexity: O(n)
//Space complexity: O(1)
public boolean lemonadeChange(int[] bills) {
    int[] arr = new int[3];
    for(int bill: bills){
        switch(bill){
            case 5: 
                arr[0]++;
                break;
            case 10:
                arr[1]++;
                if(arr[0] == 0) return false;
                arr[0]--;
                break;
            case 20:
                arr[2]++;
                if(arr[0] == 0 || (arr[1] == 0 && arr[0] < 3)){
                    return false;
                }
                if(arr[1] > 0){
                    arr[1]--; arr[0]--;
                }else arr[0] -= 3;
                break;
        }
    }
    return true;
}

public boolean lemonadeChange(int[] bills){
    int five = 0, ten = 0;
    for(int bill: bills){
        if(bill == 5) five++;
        if(bill == 10){
            ten++;
            if(five > 0){
                five--;
            }
            else return false;
        }
        if(bill == 20){
            if(ten > 0 && five > 0){
                ten--; five--;
            }else if(five >= 3){
                five -= 3;
            }else return false;
        }
    }
    return true;
}