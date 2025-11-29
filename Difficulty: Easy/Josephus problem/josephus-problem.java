class Solution {
    public int solve(int k, int index,ArrayList<Integer>arr ){
        if(arr.size()==1){
            
            return arr.get(0);
        }
        index=(index+k-1)%arr.size();
        arr.remove(index);
        return solve(k,index,arr);
        
        
    }
    public int josephus(int n, int k) {
        // code here
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        return solve(k,0,arr);
        
    }
}