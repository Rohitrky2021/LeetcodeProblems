class Solution1 {
    public boolean canBeEqual(int[] target, int[] arr) {

        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(target,arr);
        
    }
}

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n=arr.length;
        int freq[]=new int[1000+2];

        for(int x:target){
            freq[x]++;
        }

        for(int x:arr){
            if(freq[x]==0)return false;
            else{
                freq[x]--;
            }


        }
        


        return true;
        
    }
}