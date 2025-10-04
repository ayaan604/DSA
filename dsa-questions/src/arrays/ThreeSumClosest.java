package arrays;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		ThreeSumClosest main = new ThreeSumClosest();
		int[] num = {-1,2,1,-4}; // {-4,-1,1,2}
		int target = 1;
		int result;
		
		result = main.threeSumClosest(num, target);
		
		System.out.println(result);
	}

	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length, targetLocal, l, r;
		int globalDiff = Integer.MAX_VALUE;
		Arrays.sort(nums);
		
		for(int i=0;i<n-2;i++) {
			l = i+1;
			r = n-1;
			
			targetLocal = target - nums[i];
			
			while(l<r) {
				if(Math.abs(nums[l] + nums[r] - targetLocal) < Math.abs(globalDiff)) {
					globalDiff = nums[l] + nums[r] - targetLocal;
				}
//				globalDiff = Math.min(targetLocal - nums[l] + nums[r], globalDiff);
				if(nums[l] + nums[r] >= targetLocal) {
					r--;
				} else {
					l++;
				}
			}
		}
		
		return target+globalDiff;
	}
}