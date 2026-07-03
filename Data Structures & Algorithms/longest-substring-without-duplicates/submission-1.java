class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;
        int length=0;
        int startIndex=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                startIndex=Math.max(map.get(c)+1,startIndex);
            }    
            length= i- startIndex+1;
            map.put(c,i);
            maxLength=Math.max(maxLength,length);
        }
        return maxLength;
    }
}
