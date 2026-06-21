class Solution {
    public int reverse(int x) {
        long reverse=0;
        boolean neg= (x<0);
        long num=Math.abs(x);
        while(num>0){
            reverse= reverse*10+(num%10);
            num/=10;
        }
        if(neg) reverse*=-1;
        if(reverse< Integer.MIN_VALUE || reverse> Integer.MAX_VALUE) return 0;
        return (int)reverse;
    }
}
