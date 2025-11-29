// User function Template for Java

class Solution {
    void solve(int N,String output,int one,int zero,ArrayList<String> arr){
        if(N==0){
            arr.add(output);
            return;
            
        }
        String op1=output+"1";
        solve(N-1,op1,one+1,zero,arr);
        
        if(one>zero){
            String op2=output+"0";
            // String op2=output+"0";
            // solve(N-1,op1,one+1,zero,arr);
            solve(N-1,op2,one,zero+1,arr);

            
        }
        
           

        
    }
    ArrayList<String> NBitBinary(int N) {
        
        // code here
        ArrayList<String> arr=new ArrayList<>();
        solve(N,"",0,0,arr);
        return arr;
    }
}