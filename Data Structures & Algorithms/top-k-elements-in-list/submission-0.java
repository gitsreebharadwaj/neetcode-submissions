class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b)->Integer.compare(b.getValue(), a.getValue()));
        int[] ans=new int[k];
        for(int i=0; i<k; i++) {
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }
}
