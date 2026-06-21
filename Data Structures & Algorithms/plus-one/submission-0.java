class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> sum=new ArrayList<>();
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int n = digits[i]+carry;
            carry=n/10;
            n=n%10;
            sum.add(n);
        }
        if(carry!=0) sum.add(carry);
        Collections.reverse(sum);
        return sum.stream().mapToInt(Integer::intValue).toArray();
    }
}
