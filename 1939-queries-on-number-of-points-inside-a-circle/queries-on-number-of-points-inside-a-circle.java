class Solution {

    public int sq(int x){return x*x;}
    public int[] countPoints(int[][] points, int[][] queries) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int x[]:queries){
            int count=0;
            for(int p[]:points){
                int check=sq(p[0]-x[0])+sq(p[1]-x[1]);
                int radii=x[2]*x[2];

                if(check<=radii )count++;

            }

            ans.add(count);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();

        
    }
}