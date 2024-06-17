class Solution1 {
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

class Solution2 {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int num : nums)
            arr.add(num);

        Collections.sort(arr);

        for (int i = 0; i < len; i++) {
            int index = binarySearch(arr, nums[i]);
            ans.add(index);
            arr.remove(index);
        }

        return ans;
    }

    public int binarySearch(ArrayList<Integer> arr, int target) {
        int start = 0;
        int end = arr.size() - 1;
        int mid = 0;

        while (start <= end) {
            mid = start + ((end - start) / 2);
            int val = arr.get(mid);
            if (val < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        if (arr.get(start) == target)
            return start;
        return mid;
    }
}

public class Solution3 {
    class SegTreeNode {
        int min, max; // range [min, max]
        int count;
        SegTreeNode left, right;

        public int mid() {
            return ((max + 1 - min) / 2 + min);
        }

        public SegTreeNode(int min, int max) {
            this.min = min;
            this.max = max;
            count = 0;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
        }

        SegTreeNode root = new SegTreeNode(min, max);

        for (int i = nums.length - 1; i >= 0; i--) {
            list.add(0, find(nums[i] - 1, root)); // minus 1, in case there will be a equal one
            add(nums[i], root);
        }

        return list;
    }

    private int find(int x, SegTreeNode root) {
        if (root == null)
            return 0;

        if (x >= root.max) {
            return root.count;
        } else {
            int mid = root.mid();
            if (x < mid) {
                return find(x, root.left);
            } else {
                return find(x, root.left) + find(x, root.right);
            }
        }
    }

    private void add(int x, SegTreeNode root) {
        if (x < root.min || x > root.max)
            return;

        root.count++;
        if (root.max == root.min)
            return;

        int mid = root.mid();
        if (x < mid) {
            if (root.left == null) {
                root.left = new SegTreeNode(root.min, mid - 1);
            }
            add(x, root.left);
        } else {
            if (root.right == null) {
                root.right = new SegTreeNode(mid, root.max);
            }
            add(x, root.right);
        }
    }
}

class Solution4 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i] : min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i], max);
        }
        int[] tree = new int[max + 1];
        for (int i = nums2.length - 1; i >= 0; i--) {
            res.add(0, get(nums2[i] - 1, tree));
            update(nums2[i], tree);
        }
        return res;
    }

    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num += tree[i];
            i -= i & (-i); // Use of Fenwick Tree
        }
        return num;
    }

    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i]++;
            i += i & (-i); // Use of Fenwick Tree
        }
    }

}

 
class Solution {
    int[] t = new int[100005];

    void update(int si, int ss, int se, int i) {
        // si = current_index
        // ss = starting_index
        // se = ending_index
        // i = update_till/from that is if i give the number i want to update till that
        // position
        if (ss == se) {
            t[si]++;
            return;
        }
        int mid = (ss + se) / 2;
        if (i <= mid)
            update(2 * si + 1, ss, mid, i); // looking for the particular value from which the position has to be
                                            // updated upwards, in other words looking for the leaf of that position
        else
            update(2 * si + 2, mid + 1, se, i); // if not in left look right
        t[si] = t[2 * si + 1] + t[2 * si + 2];
    }

    int query(int si, int ss, int se, int qs, int qe) {
        if (qs > se || qe < ss)
            return 0;
        if (qs <= ss && qe >= se)
            return t[si];
        // find the total frequency up to a particular number
        int mid = (ss + se) >> 1;
        return query(2 * si + 1, ss, mid, qs, qe) + query(2 * si + 2, mid + 1, se, qs, qe);
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++)
            nums[i] += 10000; // i increase the value to the negative offset, so that I can deal with negative
                              // indexes
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            ans.add(query(0, 0, 20000, 0, nums[i] - 1)); // yes look for the numbers less than the current number
            update(0, 0, 20000, nums[i]); // now update the tree to this index, by adding from here
        }
        Collections.reverse(ans);
        return ans;
    }
}
