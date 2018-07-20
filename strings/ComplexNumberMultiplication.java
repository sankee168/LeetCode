//Time complexity: O(1)
//Space complexity: O(1) as both a and b of negligible space. 
public String complexNumberMultiply(String a, String b) {
	String[] arr1 = a.split("\\+");
	String[] arr2 = b.split("\\+");
	int a1 = Integer.parseInt(arr1[0]);
	int a2 = Integer.parseInt(arr2[0]);
	int b1 = Integer.parseInt(arr1[1].substring(0, arr1[1].length()-1));
	int b2 = Integer.parseInt(arr2[1].substring(0, arr2[1].length()-1));

	int a3 = a1*a2 - (b1*b2);
	int b3 = a1*b2 + a2*b1;
	StringBuilder sb = new StringBuilder();
	sb.append(a3).append("+").append(b3).append("i");
	return sb.toString();
}