class Solution {

    public int maxSubArray(int[] marks) {
        int currsum = 0, maxsum = Integer.MIN_VALUE,mincurr=Integer.MIN_VALUE;
        for (int i = 0; i < marks.length; i++) {
                currsum += marks[i];
            if(currsum<0){
                if(mincurr<currsum) mincurr=currsum;
                currsum=0;

            }
            else{
            // if (marks[i] > currsum) { 
                if (maxsum < currsum) {
                    maxsum = currsum;
                }
            // }
            }

        }
        return maxsum<0?mincurr:maxsum;
    }
}
