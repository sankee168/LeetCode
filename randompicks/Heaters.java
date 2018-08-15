//Time complexity: O(n2)
//Space complexity: O(1)
//we check what is the max radius to each house to be in either of heaters radius
public int findRadius(int[] houses, int[] heaters) {
    int max = Integer.MIN_VALUE;
    for(int house: houses){
        int min = Integer.MAX_VALUE;
        for(int heater: heaters){
            min = Math.min(Math.abs(house-heater), min);
        }
        max = Math.max(max, min);
    }
    return max;
}

//Time complexity: O(mlogn) + O(nlogn) m is the length of houses and n is the length of heaters
//Space complexity: O(1)
public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int max = Integer.MIN_VALUE;
    for(int house: houses){
        int index = Arrays.binarySearch(heaters, house);
        if(index < 0){
            index = (index+1)*-1;
        }
        //d1 is the distance between left heater and house
        //d2 is the distance between right heater and house
        int d1 = 0, d2 = 0;
        if(index == 0){
            d1 = Integer.MAX_VALUE;
        }else{
            d1 = house-heaters[index-1];
        }            
        if(index == heaters.length){
            d2 = Integer.MAX_VALUE;
        }else{
            d2 = heaters[index]-house;
        }
        max = Math.max(max, Math.min(d1, d2));            
    }
    return max;
}
