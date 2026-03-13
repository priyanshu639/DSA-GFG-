// User function Template for Java

class Solution {
    void build(int i,int l,int r,int arr[],int seg[]){
        if(l==r){
            seg[i]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*i+1,l,mid,arr,seg);
        build(2*i+2,mid+1,r,arr,seg);
        seg[i]=seg[2*i+1]+seg[2*i+2];
    }
    int query(int i, int l,int r,int arr[],int seg[],int ql,int qr){
        // outside
        if(l>qr || r<ql){
            return 0;
        }
     
        
        //  completely inside
        if(ql<=l && qr>=r){
            return seg[i];
        }
           //overlapiing
        
        int mid=l+(r-l)/2;
         return query(2*i+1,l,mid,arr,seg,ql,qr)+query(2*i+2,mid+1,r,arr,seg,ql,qr);

        
    }
    List<Integer> querySum(int n, int arr[], int q, int queries[]) {
        // code here
        //build segment tree
        int seg[]=new int[4*n];
        
        build(0,0,n-1,arr,seg);
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i<2*q;i+=2){
            int ql=queries[i]-1;
            int qr=queries[i+1]-1;
            result.add(query(0,0,n-1,arr,seg,ql,qr));
        }
        return result;
    }
}