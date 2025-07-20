package arrays;

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive main = new FirstMissingPositive();
		int[] nums = {1,2,4,5};
		
		int result = main.firstMissingPositive(nums);
		
		System.out.println(result);
	}
	
	public int firstMissingPositive(int[] nums) {
		
		int n = nums.length, temp, curr;
		
		for(int i=0;i<n;i++) {
			if(nums[i] <= n && nums[i] > 0) {
				curr = i;
				
				while(nums[curr] <= n && nums[curr] > 0 && nums[curr] != curr+1) {
					temp = nums[nums[curr]-1];
					nums[nums[curr]-1] = nums[curr];
					nums[curr] = temp;
					
                    if( (nums[curr]-1 >=0 && nums[curr]-1 < n) && nums[curr] == nums[nums[curr]-1]) break;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			if(nums[i] != i+1) {
				return i+1;
			}
		}
		
        return n+1;
    }
}
