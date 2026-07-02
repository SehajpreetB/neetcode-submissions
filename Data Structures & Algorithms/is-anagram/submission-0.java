class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            if(!freq.containsKey(c)) return false;
            if(freq.getOrDefault(c,0)==0) return false;
            freq.put(c,freq.getOrDefault(c,0)-1);
        }
        return true;
    }
}
