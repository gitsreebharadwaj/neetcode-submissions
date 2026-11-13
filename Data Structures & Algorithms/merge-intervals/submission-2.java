class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<Pair> res=new ArrayList<>();
        int i=0;
        while(i<n) {
            int min=intervals[i][0];
            int max=intervals[i][1];
            while(i+1<n && intervals[i+1][0]<=max) {
                max=Math.max(max, intervals[i+1][1]);
                i++;
            }
            res.add(new Pair(min, max));
            i++;
        }
        int size=res.size();
        int[][] ans=new int[size][2];
        for(int x=0; x<size; x++) {
            Pair curr=res.get(x);
            ans[x][0]=curr.first;
            ans[x][1]=curr.second;
        }
        return ans;
    }
}
