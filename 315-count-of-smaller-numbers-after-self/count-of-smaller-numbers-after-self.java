class Solution {
    public List<Integer> countSmaller(int[] a) {
        
        int n = a.length;
        int []arr = compressedArray(a);
        int val= arr.length;
        
        FenwickTree BIT = new FenwickTree(val);
        List<Integer>ls = new ArrayList<>();
        
        for(int i = n; i >= 1; i--) {
            ls.add(BIT.query(arr[i] - 1));
            BIT.update(arr[i], 1);
        }
        
        Collections.reverse(ls);
        return ls;
    }
    
    private int[]compressedArray (int []a){
        int n = a.length;
      
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i : a) {
            map.put(i, 0);
        }
        
        int val = 1;
        
        for(var entry : map.entrySet()) {
            map.put(entry.getKey(), val);
            val++;
        }
        int arr[] = new int[n+1];
        for(int i =1 ; i <=n; i++) {
            arr[i] = map.get(a[i-1]);
        }
        
        return arr;
    }
}

class FenwickTree {
    int[] bit;
    int n;
    
    FenwickTree(int n) {
        this.n = n;
        this.bit = new int[n + 1];
    }
    
    public void update(int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += (i & (-i));
        }
    }
    
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= (i & (-i));
        }
        return sum;
    }
    
    public int rangeSum(int l, int r) {
        return query(r) - query(l - 1);
    }
    
}