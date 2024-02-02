// M1 Using SLiding Window 
class Solution1 {
   
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


// M2 Using Recurrsion 
class Solution {
    List<Integer> list;
    public List<Integer> sequentialDigits(int low, int high) {
        list = new ArrayList<>();
        //check combination from using 1 - 9
        combinations(low, high);
        Collections.sort(list);
        return list;
    }
    private void combinations(int low, int high){
        for(int i = 1; i <= 9; i++){
            int num = i; 
            // so the digit is minimum two digits : 10 <= low <= high <= 10^9
            for(int j = i + 1;j <= 9; j++){
                num = num * 10 + j; //two digit number
                if(num > high) break; // high is the threhold because after this the num will be a higher value
                if(low <= num && high >= num){
                    list.add(num);
                }
            }
        }
    }
}