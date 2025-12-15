// class Solution {
//     static boolean helper(int arr[],int sum,int i,int target){
//         if(i==arr.length){
//             if(target==sum) return true;
//         }
        
//         boolean skip=helper(arr,sum,i+1,target);
//         if(target>sum)return false;
//         boolean pick=helper(arr,sum,i+1,target+arr[i]);
//         return pick||skip;
//     }

//     static Boolean isSubsetSum(int arr[], int sum) {
//         // code here
//         return helper(arr,sum,0,0);
//     }
// }

class Solution {
    static boolean helper(int arr[],int sum,int i,int target,int dp[][]){
        if(i==arr.length){
            if(target==sum) return true;
            return false;
        }
        
        if(dp[i][target]!=-1){ 
            if(dp[i][target]==1) return true ;
            else return false;
            
        }
        boolean ans=false;
        
        boolean skip=helper(arr,sum,i+1,target,dp);
        if(target+arr[i] > sum) return skip;
        else{
            boolean pick=helper(arr,sum,i+1,target+arr[i],dp);
            ans = pick || skip ;
            if(ans==true) dp[i][target]=1; 
            else dp[i][target]=0;
        }
        return ans;
    }

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        // target and i is variying 
        // target 0 to sum and i is 0 to arr.length;
        int n=arr.length;
        int dp[][]=new int[n+1][sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=-1;
            }
        }
        return helper(arr,sum,0,0,dp);
    }
}