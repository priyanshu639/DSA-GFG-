class Solution {
    ArrayList<ArrayList<Integer>>ans=new ArrayList<>();
    public void helper(int colidx,ArrayList<ArrayList<Integer>> grid,ArrayList<Integer>temp,int n){
        if(colidx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0;row<n;row++){
            if(check(row,colidx,grid,n)){
                grid.get(row).set(colidx,1);
                temp.add(row+1);
                helper(colidx+1,grid,temp,n);
                // undo
                grid.get(row).set(colidx,0);
                temp.remove(temp.size()-1);
                
                
            }
        }
    }
    
    public boolean check(int rowidx,int colidx,ArrayList<ArrayList<Integer>> grid,int n){
        // for rows
        for(int row=0;row<colidx;row++){
            if(grid.get(rowidx).get(row)==1){
                return false;
            }
        }
        // for diagonal1
        int i=rowidx;
        int j=colidx;
        while(i>=0 && j>=0){
            if(grid.get(i).get(j)==1){
                return false;
            }
            i=i-1;j=j-1;
        }
        // for diagonal2
        i=rowidx;
        j=colidx;
        while(i<n && j>=0){
            if(grid.get(i).get(j)==1){
                return false;
            }
            i=i+1;j=j-1;
        }
        return true;
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> grid=new ArrayList<>();
        ArrayList<Integer>temp=new ArrayList<>();
         for (int i = 0; i < n; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < n; j++) grid.get(i).add(0);
        }
        
        helper(0,grid,temp,n);
        return ans;
        
    }
}