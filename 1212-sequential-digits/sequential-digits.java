class Solution {
   
    public List<Integer> sequentialDigits(int low, int high) {
        String seqNum = "123456789";
         List<Integer> list = new ArrayList<>();

        int minWindow = String.valueOf(low).length();
        int maxWindow = String.valueOf(high).length();
   

            while(minWindow <= maxWindow){
            for(int j = 0; j + minWindow <= 9; j++){
                String str = seqNum.substring(j, j + minWindow);
                int num = Integer.parseInt(str);
                if(num > high) break;
                if(low <= num && high >= num){
                    list.add(num);
                }
            }
            minWindow++;
        }
        return list;
    }

}