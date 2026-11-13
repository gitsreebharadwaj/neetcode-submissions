class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans=new HashSet<>();
        for(int i=0; i<n; i++) {
            int j=i+1;
            int k=n-1;
            while(j<k) {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if(sum>0) {
                    k--;
                }
                else if(sum<0) {
                    j++;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}
