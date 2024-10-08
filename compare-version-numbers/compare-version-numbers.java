class Solution {
    public int compareVersion(String version1, String version2) {
        
        String [] one = version1.split("\\.");
        String [] two = version2.split("\\.");

        for(int i=0;i<Math.max(one.length,two.length);i++){

            int o = Integer.parseInt(i<one.length ? one[i]:"0");
            int t = Integer.parseInt(i<two.length ? two[i]:"0");
            if(o > t){
                return 1;
            }
            else if (o < t){
                return -1;
            }
        }
        return 0;
    }
}