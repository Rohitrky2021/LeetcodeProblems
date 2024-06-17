import java.util.*;

class Solution {
    static class SegmentTree {
        private int[] tree;
        private int n;

        private boolean isPeak(final int[] nums, int i) {
            if (i <= 0 || i >= nums.length - 1) return false;
            return nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
        }

        public SegmentTree(final int[] nums) {
            n = nums.length;
            tree = new int[4 * n];
            build(nums, 0, 0, n - 1);
        }

        private void build(final int[] nums, int node, int start, int end) {
            if (start == end) {
                tree[node] = isPeak(nums, start) ? 1 : 0;
            } else {
                int mid = (start + end) / 2;
                build(nums, 2 * node + 1, start, mid);
                build(nums, 2 * node + 2, mid + 1, end);
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public void update(final int[] nums, int idx) {
            update(nums, 0, 0, n - 1, idx);
        }

        private void update(final int[] nums, int node, int start, int end, int idx) {
            if (start == end) {
                tree[node] = isPeak(nums, idx) ? 1 : 0;
            } else {
                int mid = (start + end) / 2;
                if (start <= idx && idx <= mid) {
                    update(nums, 2 * node + 1, start, mid, idx);
                } else {
                    update(nums, 2 * node + 2, mid + 1, end, idx);
                }
                tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
            }
        }

        public int query(int l, int r) {
            return query(0, 0, n - 1, l, r);
        }

        private int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l) {
                return 0;
            }
            if (l <= start && end <= r) {
                return tree[node];
            }
            int mid = (start + end) / 2;
            int leftQuery = query(2 * node + 1, start, mid, l, r);
            int rightQuery = query(2 * node + 2, mid + 1, end, l, r);
            return leftQuery + rightQuery;
        }
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Integer> results = new ArrayList<>();
        SegmentTree segTree = new SegmentTree(nums);

        for (int[] query : queries) {
            int type = query[0];
            if (type == 1) {
                int l = query[1];
                int r = query[2];
                results.add(segTree.query(l + 1, r - 1));
            } else if (type == 2) {
                int index = query[1];
                int val = query[2];
                nums[index] = val;
                if (index > 0) segTree.update(nums, index - 1);
                segTree.update(nums, index);
                if (index < n - 1) segTree.update(nums, index + 1);
            }
        }

        return results;
    }
}
