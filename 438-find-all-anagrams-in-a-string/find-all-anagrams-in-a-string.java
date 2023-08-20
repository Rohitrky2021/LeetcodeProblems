class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int arr_p[] = new int[26];
        int curr[]  = new int[26];
        int change_req = p.length();
        List<Integer>ans = new LinkedList<>();
        for(int i = 0; i<p.length(); i++) arr_p[p.charAt(i)-'a']++;

        for(int i = 0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            curr[c]++;
            change_req--;
            if(i>=p.length())
            {
                curr[s.charAt(i-p.length())-'a']--;
                change_req--;
            }

            if(change_req<=0){
                int res = compare(arr_p,curr);
                if(res==0) {ans.add(i-p.length()+1);change_req=1;}
                else change_req=res;
            }
        }
        return ans;        
    }
    private int compare(int[] arr_p, int[] curr){
        int ans = 0;
        for(int i=0; i<26; i++){ 
           ans += Math.abs(arr_p[i]-curr[i]);
        }
        return ans;
    }
}