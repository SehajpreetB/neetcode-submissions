class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagrams =new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s=strs[i];
            char[] str=s.toCharArray();
            Arrays.sort(str);
            String key = new String(str);
            anagrams.putIfAbsent(key, new ArrayList<>());
            anagrams.get(key).add(s);
        }
        System.out.println(anagrams.size());
        List<List<String>> ans=new ArrayList<>();
        for(List<String> a: anagrams.values()){
            ans.add(a);
        }
        return ans;
    }
}
