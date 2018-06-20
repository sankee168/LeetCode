//Assume G(n) is the function which determines the number of unique BSTs from 1 to n.
// G(n) = F(1, n) + F(2, n) + ....
// F(i, n) is the number of BST with i as root which means F(i, n) = G(i-1)*G(n-i)
// G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ....
public int numTrees(int n) {
	int[] G = new int[n+1];
	G[0] = 1;
	G[1] = 1;
	for(int i = 2; i < n+1; i++){
		for(int j = 0; j < i; j++){
			G[i]+= G[j][i-j-1];
		}
	}
	return G[n];
}