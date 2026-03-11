class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        int N=arr.length;
        List<Integer>res=new ArrayList<>();
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<N;i++){
            if(arr[i]<0){
                q.add(i);
            }
        }
        for(int i=0;i<N-k+1;i++){
            if(q.size()>0 &&q.peek()<i){
                q.remove();
            }
            if(q.size()>0 && q.peek()<=i+k-1){
                res.add(arr[q.peek()]);
            }
            else if(q.size()==0){
                res.add(0);
                
            }
            else{
                res.add(0);
            }
            
        }
        return res;
    }
}