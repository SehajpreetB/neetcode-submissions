class Solution {
    public Boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        }
        return true;
    }
    public String longestPalindrome(String s){ 
        int n= s.length();
        if(n<=1) return s;
        int in=0;
        int maxLength=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s.substring(i,j+1))){
                    if(maxLength< (j-i+1)){
                        in= i;
                        maxLength= (j-i+1);
                    }
                }
            }
        }
        if(maxLength==0) return "";
        return s.substring(in,in+maxLength);
    }
}
