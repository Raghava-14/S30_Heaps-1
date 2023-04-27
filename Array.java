//Time = O(n log n)
//Space = O(1)

//Brute Force
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Sort the array in descending order
        Arrays.sort(nums);
        int n = nums.length;
        // Return the kth largest element
        return nums[n - k];
    }
}
