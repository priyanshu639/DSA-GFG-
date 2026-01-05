class Solution {
    public boolean helper(int arr[],int k,int mid){
        int sum=0;
        int box=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>mid) return false;
            if(arr[i]<=mid-sum) sum+=arr[i];
            else{
                box++;
                if(box>k) return false;
                sum = arr[i];
            }
        }
        return true;

    }
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k)return -1;
        int max=0;
        for(int i=0;i<arr.length;i++){
            max+=arr[i];
        }
        int left=0;
        int right=max;
        int ans=Integer.MAX_VALUE;
        while(left<=right){

            int mid=(right+left)/2;
            if(helper(arr,k,mid)) {
                ans=Math.min(ans,mid);
                right=mid-1;
            }
            else left=mid+1;
        } 
        return ans;
    
    }
}