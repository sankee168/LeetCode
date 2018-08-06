//split with . and keep comparing till you reach one of the string arrays end. then use util
//time complexity: O(m+n) where m is the length of version1 and n is the length of version2
//space complexity: O(m+n)
public int compareVersion(String version1, String version2) {
    String[] arr1 = version1.split("\\.");
    String[] arr2 = version2.split("\\.");
    int min = Math.min(arr1.length, arr2.length);
    for(int i = 0; i < min; i++){
        int a = Integer.parseInt(arr1[i]);
        int b = Integer.parseInt(arr2[i]);
        if(a > b) return 1;
        else if(a < b) return -1;
    }        
    if(arr1.length > arr2.length) return util(arr1, min);
    else if(arr2.length > arr1.length) return -1*util(arr2, min);
    else return 0;
}    
private int util(String[] arr, int i){
    for(; i < arr.length; i++){
        int a = Integer.parseInt(arr[i]);
        if( a > 0) return 1;
    }
    return 0;
}