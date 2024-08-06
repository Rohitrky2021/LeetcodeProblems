class Solution {
public:
struct dsu {
    vector<int> parent, s;
    int numCC;

    dsu(int n) {
        parent = vector<int>(n);
        numCC = n;
        s = vector<int>(n, 1);
        for (int i = 1; i < n; ++i)
            parent[i] = i;
    }

    int find(int v) {
        if (v == parent[v])
            return v;
        return parent[v] = find(parent[v]);
    }

    void unite(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            numCC--;
            if (u < v)
                swap(u, v);
            parent[v] = u;
            s[u] += s[v];
        }
    }

    };

    vector<int> shortestDistanceAfterQueries(int n, vector<vector<int>>& queries) {
        dsu d(n);

        vector<int> ans;
        for (auto q: queries){
            int L = d.find(q[0]);
            int R = d.find(q[1]-1);
            
            for (int i = L; i < R;) {
                if (d.find(i) + 1 <= R)
                    d.unite(i, d.find(i) + 1);
                else
                    break;
                i = d.find(i);
            }

            ans.emplace_back(d.numCC-1);
        }

        return ans;
        }
};