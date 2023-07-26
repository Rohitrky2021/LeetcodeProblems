class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int left = 1, right = (int) 1e9;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReachDestination(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return canReachDestination(dist, hour, left) ? left : -1;
    }

    private boolean canReachDestination(int[] dist, double hour, int speed) {
        double totalHours = 0;
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            totalHours += Math.ceil((double) dist[i] / speed);
        }

        totalHours += (double) dist[n - 1] / speed;

        return totalHours <= hour;
    }
}



// class Solution {
//     public int minSpeedOnTime(int[] dist, double hour) {
//         int n=dist.length;
//         int max=0;       //max hours that can sole the problem easily
//         if(hour<=(double)(dist.length-1)){
//             //hours is less than no. of stations -1 return -1.
//             return -1;
//         }
//         for(int num:dist){
//             //max distance --->max speed
//             max=Math.max(num,max);
//         }
//         double dec=(hour*100)%100;
//         //decimal value to be traversed by last train
//         int d=(int)dec;
//         if(d==0){
//             d=1;
//         }
//         int speed=(dist[n-1] *100)/d;      //min speed to get distance dist[n-1] in decimal value of hours left
//         max=Math.max(speed,max);
//         //get max between both
//         int i=1,j=max;
//         while(i<j){
//             int mid=(i+j)/2;
//             //if mid value return true
//             if(calc(dist,hour,mid)){
//                 //get upper bound to mid
//                 j=mid;
//             }else{
//                 //gte lower bound to mid+1
//                 i=mid+1;
//             }
//         }
//         if(calc(dist,hour,i)){
//             return i;
//         }else{
//             return i+1;
//         }
//     }
//     //function to check if speed is feasible to traverse all the distances
//     public boolean calc(int[] dist, double hour,int speed){
//         double h=0;
//         int n=dist.length;
//         for(int i=0;i<n-1;i++){
//             //for 0....n-2 add ceil value cause next train can only be accessed at integer values
//             h+=Math.ceil((dist[i]/(double)speed));
//         }
//         //add last double val without ceil val.
//         h+=dist[n-1]/(double)speed;
//         //check if h<=hour
//         return h<=hour;
//     }
// }
