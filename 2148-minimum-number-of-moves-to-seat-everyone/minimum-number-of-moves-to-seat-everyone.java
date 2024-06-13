class Solution1 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
         Arrays.sort(students);
         int ans=0;

         for(int i=0;i<seats.length;i++){
            ans+=Math.abs(seats[i]-students[i]);
         }
         return ans;

    }
}

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int[] pos = new int[101];
        int n = seats.length;
        for(int i = 0; i < n; i++){
            pos[seats[i]]++;
            pos[students[i]]--;
        }
        int res = 0;
        int current = 0;
        for(int i: pos){
            res += Math.abs(current);
            current += i;
        }
        return res;
    }
}