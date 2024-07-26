class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         int[][] dist = new int[n][n];

               for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

               for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

            int minNeighborCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int neighborCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    neighborCount++;
                }
            }
            if (neighborCount <= minNeighborCount) {
                minNeighborCount = neighborCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
    }

