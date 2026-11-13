class Solution {
    public int longestConsecutive(int[] arr) {
        int n=arr.length;
        if(n==0) {
            return 0;
        }
        HashSet<Integer> set=new HashSet<>();
        int maxLen=1;
        for(int num : arr) {
            set.add(num);
        }
        for(int num : set) {
            if(!set.contains(num-1)) {
                int x=num;
                int len=1;
                while(set.contains(x+1)) {
                    x+=1;
                    len++;
                }
                maxLen=Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
