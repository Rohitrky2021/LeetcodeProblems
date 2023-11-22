class Solution {
    public long countQuadruplets(int[] nums) {
        
        int n = nums.length;
        
        
        Fenwick t1 = new Fenwick(new int[n + 1]);
        Fenwick t2 = new Fenwick(new int[n + 1]);
        long ans = 0;
        
        for(int i=1;i<=n;i++) t2.update(i,1);
        
        for(int j = 0 ; j < n ; j++) {
            
            t2.update(nums[j], -1);
            
            for(int k = j + 1 ; k < n ; k++) {
                
                t2.update(nums[k],-1);
                
                if(nums[j] > nums[k]) {
                    
                    long c1 = t1.query(1, nums[k]);
                    long c2 = t2.query(nums[j], n);
                    
                    ans += (c1 * c2);
                }
            }
            
            for(int k = j + 1 ; k < n ; k ++) t2.update(nums[k], 1);
            
            t1.update(nums[j],1);
        }
        
        return ans;
    }
}

class Fenwick {

    long[] bit;
 
    public Fenwick(int arr[]) {
        
        // arr has to be in 1-based indexing
		bit = new long[arr.length]; 
 
        for(int i = 1 ; i < arr.length ; i++) {

			update(i, arr[i]);
		}
    }
 
    public long sum(int index) {
        
		long sum = 0;

		while(index > 0) {

			sum += bit[index];
			index = index - (index & -index);
		}

		return sum;
    }

	public long query(int l,int r) {

		r = Math.min(r, bit.length - 1);
        	l = Math.max(l, 1);

		return sum(r) - sum(l - 1);

	}

    public void update(int index, int val) {

		while(index < bit.length) {

			bit[index] += val;
			index = index + (index & -index);
		}
    }
}