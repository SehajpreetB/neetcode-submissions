class Solution {
    public int squareSum(int n){
        int sum=0;
        while(n>0){
            sum+= (n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
    Set<Integer> values=new HashSet<>();
    public boolean isHappy(int n) {
        if(n==1) return true;
        if(values.contains(n)) return false;
        values.add(n);
        return isHappy(squareSum(n));
    }
}
