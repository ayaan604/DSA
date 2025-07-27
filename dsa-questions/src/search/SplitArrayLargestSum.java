package search;

/*
 Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

 Return the minimized largest sum of the split.

 A subarray is a contiguous part of the array.
 * */

public class SplitArrayLargestSum {
	
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        long l = nums[0], r = sum, mid;

        while(r-l > 1){
            mid = l + (r-l)/2;

            if(canSplitArray(nums,n,k,mid)){
                r = mid;
            } else{
                l = mid+1;
            }
        }

        if(canSplitArray(nums,n,k,l)) return (int)l;

        return (int)r;
    }

    public boolean canSplitArray(int[] nums, int n, int k, long l){
        int count = 0;
        long sum = 0;

        for(int i=0;i<n;i++){
            if(nums[i] > l) return false;
            if(sum+nums[i]>l){
                count++;
                sum = nums[i];
            } else{
                sum += nums[i];
            }
        }

        return count < k;
    }
}