//Idea here is to sort the given input based on the minutes
//Time complexity: O(nlogn) + O(n) for sorting
//Space complexity: O(1)
public int findMinDifference(List<String> timePoints) {
    Collections.sort(timePoints, new TimeComparator());
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < timePoints.size()-1; i++){
        int first = toMinutes(timePoints.get(i));
        int second = toMinutes(timePoints.get(i+1));
        min = Math.min(min, second-first);            
    }        
    int first = toMinutes(timePoints.get(0));
    int last = toMinutes(timePoints.get(timePoints.size()-1));
    min = Math.min(min, 1440 - last + first);
    return min;
}    
class TimeComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2){
        int first = toMinutes(s1);
        int second = toMinutes(s2);
        if(first > second) return 1;
        else if(first < second) return -1;
        return 0;
    }
}    
private int toMinutes(String s){
    String[] arr = s.split("\\:");
    return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
}


//We know that there are only 1440 minutes in 24 hours, we use a boolean array of that size. 
//we iterate through the list and make each of them as true. if it is already true that means it is same time we return 0
//once that is done, we iteate over the boolean array to check on difference in indices between two true values
//Here we keep track of what is the least minute and largest minute to check on the corner case if 1440-last+first is min
//Time complexity: O(n)
//Space complexity: O(1) as we are using constant space
public int findMinDifference(List<String> timePoints) {
    boolean[] arr = new boolean[24*60];
    for(int i = 0; i < timePoints.size(); i++){
        String curr = timePoints.get(i);
        int minutes = toMinutes(curr);
        if(arr[minutes]) return 0;
        arr[minutes] = true;
    }

    int last = Integer.MIN_VALUE, first = Integer.MAX_VALUE, prev = 0, min = Integer.MAX_VALUE;
    for(int i = 0; i < 24*60; i++){
        if(arr[i]){
            if(first != Integer.MAX_VALUE){
                min = Math.min(min, i-prev);
            }
            first = Math.min(first, i);
            last = Math.max(last, i);
            prev = i;
        }
    }

    min = Math.min(min, 1440-last+first);
    return min;
}