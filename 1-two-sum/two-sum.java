class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] a =new int[2];
        int l = nums.length;
        
        if(l == 0){
            return a;
        }
        for(int i=0;i< l-1;i++){
            for(int j=i+1; j< l; j++){
                if((nums[i] + nums[j]) == target){
                    a[0]= i;
                    a[1]= j;
                    break;
                }
        }}
        return a;
        
    }
}