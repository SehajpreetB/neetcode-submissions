class Solution {

    public boolean nextString(String one, String two) {
        if (one.length() != two.length()) return false;

        int count = 0;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return 0;

        Map<String, List<String>> adj = new HashMap<>();

        // Create an empty list for every word
        for (String word : wordList) {
            adj.put(word, new ArrayList<>());
        }

        // Add beginWord if it is not already present
        if (!adj.containsKey(beginWord)) {
            adj.put(beginWord, new ArrayList<>());
        }

        // Build graph among words in wordList
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {

                if (nextString(wordList.get(i), wordList.get(j))) {
                    adj.get(wordList.get(i)).add(wordList.get(j));
                    adj.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        // Connect beginWord with all valid neighbors
        for (String word : wordList) {
            if (nextString(beginWord, word)) {
                adj.get(beginWord).add(word);
                adj.get(word).add(beginWord);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);

        int path = 1;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                String node = q.poll();

                if (node.equals(endWord)) {
                    return path;
                }

                for (String nei : adj.get(node)) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        q.offer(nei);
                    }
                }
            }

            path++;
        }

        return 0;
    }
}