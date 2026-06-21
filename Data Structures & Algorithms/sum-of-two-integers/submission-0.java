class Solution {
    public int getSum(int a, int b) {
        int carry=0;
        int sum=0;
        for(int i=0;i<32;i++){
            int one= (a&1);
            int two= (b&1);
            int bit= one^two^carry;
            a>>=1;
            b>>=1;
            sum |= (bit << i);
            carry = (one & two)| (one & carry)| (two & carry);
        }
        return sum;
    }
}
