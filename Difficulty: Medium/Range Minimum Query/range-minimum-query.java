/* The functions which
builds the segment tree */
class GfG {
    static int st[];
    public static void buildTree(int i,int l,int r,int arr[]){
        if(l==r) {
            st[i]=arr[l];
            return;
        }
        int mid=l+(r-l)/2;
        buildTree(2*i+1,l,mid,arr);
        buildTree(2*i+2,mid+1,r,arr);
        st[i]=Math.min(st[2*i+1],st[2*i+2]);
        
    }

    public static int[] constructST(int arr[], int n) {
        // Add your code here
        st=new int[4*n];
        buildTree(0,0,n-1,arr );
        return st;
        
    }
    public static int query(int i,int l,int r,int ql,int qr){
        if(l>qr || ql>r){
            return Integer.MAX_VALUE;
        }
        if(ql<=l && r<=qr){
            return st[i];
        }
        int mid=l+(r-l)/2;
        return Math.min(query(2*i+1,l,mid,ql,qr),query(2*i+2,mid+1,r,ql,qr));
        
    }

    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int ql, int qr) {
        // Add your code here
         return query(0,0,n-1,ql,qr );
        
    }
}