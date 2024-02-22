class Solution1 {
    // Same as Celebrity Problem 
    public int findJudge(int n, int[][] t) {
        // int n=t.length;
        int hash[]=new int[n];
        int possible=-1;

        for(int[] x:t){
            hash[x[1]-1]++;
        }

        for(int i=0;i<n;i++){
            if(hash[i]==n-1) possible=i+1;
        }

        for(int[] x:t){
           if(x[0]==possible)return -1;
        }

       return possible; 
        
    }
}

//  SImply a graph whoes outDegree is Simply 0
class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) 
            return 1;
        int[] count = new int[n + 1];
        for (int[] person : trust) {
            count[person[0]]--;
            count[person[1]]++;
        }

        for (int person = 0; person < count.length; person++) {
            if (count[person] == n - 1) return person;
        }
        return -1;
    }
}