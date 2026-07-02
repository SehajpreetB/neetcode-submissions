class CountSquares {

    Map<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        points.put(key, points.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int ax = point[0];
        int ay = point[1];
        int ans = 0;

        for (String key : points.keySet()) {

            String[] parts = key.split(",");
            int px = Integer.parseInt(parts[0]);
            int py = Integer.parseInt(parts[1]);

            // Must be a valid diagonal
            if (px == ax || py == ay) continue;
            if (Math.abs(px - ax) != Math.abs(py - ay)) continue;

            String p1 = px + "," + ay;
            String p2 = ax + "," + py;

            if (points.containsKey(p1) && points.containsKey(p2)) {
                ans += points.get(key) * points.get(p1) * points.get(p2);
            }
        }

        return ans;
    }
}
