//This is bit interesting
//General idea is to start from end, keep clubbing K chars
//when we reach k chars and see that we have more chars we append "-"
//but there can be more "-" till the beginning. so we have to append when we actually encounter a valid char
//so we divide by K+1. As there will be either K or K + x(K+1) chars in the current string
//and as we are doing in the reverse order, we have to reverse the string at the end
//Time complexity: O(n)
public String licenseKeyFormatting(String S, int K) {
	//each group should contain K letters
	//first group can have less but should have atleast one
	//convert lowercase to uppercase
	StringBuilder sb = new StringBuilder();
	for(int i = S.length()-1; i >= 0; i--){
		if(S.charAt(i) != '-'){			
            if(sb.length()%(K+1) == K){
			    sb.append("-");
		    }
            sb.append(Character.toUpperCase(S.charAt(i)));
		}
	}
	return sb.reverse().toString();
}