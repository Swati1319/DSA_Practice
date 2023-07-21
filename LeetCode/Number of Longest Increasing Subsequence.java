class Solution {
    public int findNumberOfLIS(int[] nums) {
        TreeSet<Integer> ts = new TreeSet();
        for (int v : nums) {
            ts.add(v);
        }
        int idx = 1;
        Map<Integer, Integer> m = new HashMap<>();
        for (int v : ts) {
            m.put(v, idx++);
        }
        int n = m.size();
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int v : nums) {
            int x = m.get(v);
            int[] t = tree.query(x - 1);
            tree.update(x, t[0] + 1, Math.max(t[1], 1));
        }
        return tree.query(n)[1];
    }
}

class BinaryIndexedTree {
    private int n;
    private int[] c;
    private int[] d;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
        d = new int[n + 1];
    }

    public void update(int x, int val, int cnt) {
        while (x <= n) {
            if (c[x] < val) {
                c[x] = val;
                d[x] = cnt;
            } else if (c[x] == val) {
                d[x] += cnt;
            }
            x += lowbit(x);
        }
    }

    public int[] query(int x) {
        int val = 0;
        int cnt = 0;
        while (x > 0) {
            if (val < c[x]) {
                val = c[x];
                cnt = d[x];
            } else if (val == c[x]) {
                cnt += d[x];
            }
            x -= lowbit(x);
        }
        return new int[] {val, cnt};
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}
