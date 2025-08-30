package dp;

import java.util.Arrays;

/*

Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:

Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.

You should perform the cuts in order, you can change the order of the cuts as you wish.

The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.

Return the minimum total cost of the cuts.

*/

public class MinimumCostoToCutStick {

	public static void main(String[] args) {
		MinimumCostoToCutStick main = new MinimumCostoToCutStick();
		int n = 9, cuts[] = {5,6,1,4,2};
		
		int result = main.minCost(n, cuts);
		
		System.out.println(result);

	}
	
	public int minCost(int n, int[] cuts) {
		int m = cuts.length;
		Arrays.sort(cuts);
		
		int[] _cuts = new int[m+2];
		
		_cuts[0] = 0; _cuts[m+1] = n;
		
		for(int i=1;i<m+1;i++) {
			_cuts[i] = cuts[i-1];
		}
		int[][] dp = new int[m+2][m+2];
		
		for(int i=0;i<m+2;i++) {
			for(int j=i;j<m+2;j++) {
				dp[i][j] = -1;
			}
		}
		
		return solve(_cuts,dp,0,m+1);
    }
	
	private int solve(int[] cuts, int[][] dp, int l, int r) {
		
		if(dp[l][r] != -1) {
			return dp[l][r];
		}
		
		if(r-l <= 1) {
			return dp[l][r] = 0;
		}
		
		int result = Integer.MAX_VALUE; // cuts[r]-cuts[l]
		
		for(int i=l+1;i<=r-1;i++) {
			result = Math.min(result, solve(cuts,dp,l,i) + solve(cuts,dp,i,r));
		}
		
		return dp[l][r] = (result + cuts[r]-cuts[l]);
	}

}
