//As given in the question, lets say there are n papers. 
//we have to find out x such that x number of papers which have got atleast x citations
//As this array is sorted in number of citations, we traverse from beginning
//while traversing at ith index, that means that n-i papers have got atleast arr[i] citations
//so  we iterate till arr[i] < n-i
//when loop condition fails, that means n-i paper have alteast arr[i] citations
public int hIndex(int[] citations) {
   int i = 0, n = citations.length;
    while(i < n && citations[i] < n-i) i++;
    return n-i;
}

//As this array is sorted we can check this condition in binary search manner too


public int hIndex(int[] citations) {
	return util(citations, 0, citations.length-1, citations.length);
}

private int util(int[] citations, int i, int j, int n){
	if(i==j) return n-i;
	int mid = (i+j)/2;
	if(citations[mid] == n-mid) return n-mid;
	if(citations[mid] < n-mid){
		return util(citations, mid+1, j, n);
	}else return util(citations, i, mid-1);
}