class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freqMap = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freqMap[s1.charAt(i) - 'a']++;
        }

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqMap, count)) return true;

        for (int r = s1.length(); r < s2.length(); r++) {

            count[s2.charAt(r - s1.length()) - 'a']--;
            count[s2.charAt(r) - 'a']++;

            if (Arrays.equals(freqMap, count)) {
                return true;
            }
        }

        return false;

    }
}
