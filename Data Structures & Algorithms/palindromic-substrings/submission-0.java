class Solution {
    public int countSubstrings(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while(l>=0 && r<s.length() && s.charAt(r)== s.charAt(l)){
                count++;
                l--;
                r++;
            }
            l=i;r=i+1;
            while(l>=0 && r<s.length() && s.charAt(r)== s.charAt(l)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}
