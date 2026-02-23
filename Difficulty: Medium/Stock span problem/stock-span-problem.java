
import java.util.*;

class Solution {
    
    class Pair {
        int i;
        int val;
        
        Pair(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }
    
    public ArrayList<Integer> calculateSpan(int[] arr) {
        
        Stack<Pair> st = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            
            
            while(!st.isEmpty() && st.peek().val <= arr[i]) {
                st.pop();
            }
            
            int span;
            
            if(st.isEmpty()) {
                span = i + 1;
            } else {
                span = i - st.peek().i;
            }
            
            result.add(span);
            
            st.push(new Pair(i, arr[i]));
        }
        
        return result;
    }
}