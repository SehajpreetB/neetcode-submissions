class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
         // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int wt = time[2];
            adj.get(u).add(new int[]{v, wt});
        }

        // Distance array
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Min-heap: {node, currentDistance}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int node = curr[0];
            int currDist = curr[1];

            // Skip outdated entries
            if (currDist > dist[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int wt = nei[1];

                if (currDist + wt < dist[next]) {
                    dist[next] = currDist + wt;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int maxTime = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
