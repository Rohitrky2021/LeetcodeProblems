class Solution {
    char[] bits;
    int[] ptable;

    class Node implements Comparable<Node> {
        long x = 0L;
        int n = 0;

        public Node(long x, int n) {
            this.x = x;
            this.n = n;
        }
        public void merge(Node other) {
            this.x <<= other.n;
            this.x |= other.x;
            this.n += other.n;
        }
        public Node expend() {
            x = (x << 1) | (1L << (n + 1));
            n += 2;
            return this;
        }
        public int compareTo(Node other) {
            int mlen = Math.max(this.n, other.n);
            long cx = this.x << (mlen - this.n);
            long co = other.x << (mlen - other.n);

            if (cx > co) return -1;
            if (cx < co) return 1;
            return (this.n - other.n);
        }
        public String toString() {
            StringBuilder sb = new StringBuilder();
            long b = 1L << (this.n - 1);
            while (b > 0) {
                char c = ((b & x) > 0) ? '1' : '0';
                sb.append(c);
                b >>= 1;
            }
            return sb.toString();
        }
    }
    private int helper_processing(int k) {
        if (k == bits.length) {
            return -1;
        }
        if (bits[k] == '1') {
            int r = helper_processing(k + 1);
            ptable[k] = r;
            ptable[r] = k;
            return helper_processing(r + 1);
        }
        return k;
    }
    public String makeLargestSpecial(String s) {
        bits = s.toCharArray();
        ptable = new int[bits.length];
        helper_processing(0);
        return helper_enlarge(-1).toString();
    }
    private Node helper_enlarge(int k) {
        int close = (k < 0) ? ptable.length : ptable[k];
        if (k + 1 == close) {
            return new Node(0L, 0);
        }
        PriorityQueue<Node> q = new PriorityQueue<>();
        int e = k;
        while (e + 1 < close) {
            k = e + 1;
            e = ptable[k];
            q.add(helper_enlarge(k));
        }
        Node curr = new Node(0L, 0);
        while (!q.isEmpty()) {
            Node h = q.poll();
            curr.merge(h.expend());
        }
        return curr;
    }
}