// class Solution {

    

//     public int majorityElement(int[] arr) {
//         HashMap<Integer,Integer> map=new HashMap<>();

//         Set<Integer> keyset=map.keySet();
//         for (int i = 0; i < arr.length; i++) {
//             if(map.containsKey(arr[i])){
//                 map.put(arr[i], map.get(arr[i])+1);
//             }
//             else{
//                 map.put(arr[i], 1);
//             }
            

//         }

        
//         for(Integer key:keyset){
//             if(map.get(key)>arr.length/2){
//                 System.out.println(key.intValue());
//                 return key.intValue(); 
//             }
//         }
//         return -1;
//     }
// }


public class Solution {
    public int majorityElement(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
}