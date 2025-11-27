class Solution {
    public static void reverse(Stack<Integer> st){
        if(st.size()==1){
            return;
        }
        int temp=st.peek();
        st.pop();
        reverse(st);
        insert(st,temp);
        
    }
    public static void insert(Stack<Integer> st,int temp){
        if(st.size()==0){
            st.push(temp);
            
            return;
        }
        int t=st.peek();
        st.pop();
        insert(st,temp);
        st.push(t);
    }
    public static void reverseStack(Stack<Integer> st) {
        // code here
        reverse(st);
    }
}
