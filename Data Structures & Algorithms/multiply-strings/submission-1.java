class Solution {
    public String multiplyUtil(String num,int x, int places){
        StringBuilder ans=new StringBuilder();
        int carry=0;
        for(int i=num.length()-1;i>=0;i--){
            int prod=(num.charAt(i)-48)*x+carry;
            int val=prod%10;
            carry=prod/10;
            ans.insert(0,(val));
        }
        if(carry>0) ans.insert(0,carry);
        //Add padding
        while(places>0){
            ans.append("0");
            places--;
        }
        return ans.toString();
    }
    public String addNumbers(String num1,String num2){
        StringBuilder res= new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        while(i>=0 && j>=0){
            int a= num1.charAt(i)-48;
            int b= num2.charAt(j)-48;
            int sum=a+b+carry;
            res.insert(0,(sum%10));
            carry=sum/10;
            i--; j--;
        }
        while(i>=0){
            int sum= num1.charAt(i)-48+carry;
            res.insert(0,(sum%10));
            carry=sum/10;
            i--;
        }
        while(j>=0){
            int sum= num2.charAt(j)-48+carry;
            res.insert(0,(sum%10));
            carry=sum/10;
            j--;
        }
        if(carry>0) res.insert(0,carry);
        return res.toString();
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String res="";
        int places=0;
        if(num1.length()<num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        for(int i=num2.length()-1;i>=0;i--){
            int x=num2.charAt(i)-48;
            String prod= multiplyUtil(num1,x,places);
            System.out.println(prod);
            places++;
            res= addNumbers(prod,res);
            System.out.println("Res "+res);
        }
        return res;
    }
}
