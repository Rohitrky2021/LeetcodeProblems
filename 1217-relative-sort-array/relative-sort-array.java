class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int freq[]=new int[1005];

        for(int i=0;i<arr1.length;i++){
            freq[arr1[i]]++;
        }

        int j=0;
        for(int i=0;i<arr2.length;i++){
            if(freq[arr2[i]]!=0){
                while(freq[arr2[i]]!=0){
                    arr1[j++]=arr2[i];
                    freq[arr2[i]]--;
                }
            }
        }

         for(int i=0;i<1001;i++){
            if(freq[i]!=0){
                while(freq[i]!=0){
                    arr1[j++]=i;
                    freq[i]--;

                }
            }
        }

        return arr1;
        
    }
}