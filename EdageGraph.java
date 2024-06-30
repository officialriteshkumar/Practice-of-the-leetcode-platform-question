class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
 UnionFind ufA = new UnionFind(n);
        UnionFind ufB = new UnionFind(n);

        int edgesAdded = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (ufA.union(edge[1] - 1, edge[2] - 1)) {
                    ufB.union(edge[1] - 1, edge[2] - 1);
                    edgesAdded++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufA.union(edge[1] - 1, edge[2] - 1)) {
                    edgesAdded++;
                }
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (ufB.union(edge[1] - 1, edge[2] - 1)) {
                    edgesAdded++;
                }
            }
        }
        if (ufA.isConnected() && ufB.isConnected()) {
            return edges.length - edgesAdded;
        } else {
            return -1;
        }
    }

    class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            count = size;
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                count--;
                return true;
            }
            return false;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean isConnected() {
            return count == 1;
        }
    }
}
