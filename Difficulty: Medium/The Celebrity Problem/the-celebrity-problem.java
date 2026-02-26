class Solution {
    public int celebrity(int M[][]) {
        // code here
        int n=M.length;
        // 1 MEANS KNOW O MEANS YOU DONT KNOW
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size()>1){
            int val1=st.pop();
            int val2=st.pop();
            if(M[val1][val2]==0) {// val1 nhi janta val2 ko it means val1 can be a potential celebrity
                st.push(val1);
            }
            else if(M[val2][val1]==0){// val2 nhi janta val1 ko ,val2 can be possible celebrity
                st.push(val2);
            }
        }
        
        //confirm karo kon celebrity h
        if (st.size()==0)return -1;
        int potentialCelb=st.pop();
        for(int j=0;j<n;j++){//col me check karo sabhi zero's h
            
            if(j != potentialCelb && M[potentialCelb][j]==1){
                return -1;
            }
            
        }
        for(int i=0;i<n;i++){ //row wise
            if(i != potentialCelb && i==potentialCelb) continue;
            if(M[i][potentialCelb]==0){
                return -1;
            }
            
        }
        return potentialCelb;
        
        
    }
}