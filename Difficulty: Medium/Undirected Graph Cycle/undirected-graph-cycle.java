import java.util.*;
class Solution {
    class pair{
        int node;
        int parent;
        pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        // convert it to adjacency list
        List<List<Integer>> ll=new ArrayList<>();
        for(int i=0;i<V;i++){
            ll.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            ll.get(u).add(v);
            ll.get(v).add(u);
        }
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,vis,ll)) return true;
                
            }
        }
        return false;
        
        
    }
    
    public boolean bfs(int start,boolean vis[],List<List<Integer>> ll){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(start,-1));
        vis[start]=true;
        while(q.size()>0){
            pair front=q.remove();
            int node=front.node;
            int parent=front.parent;
            for(int ele:ll.get(node)){
                if(!vis[ele]){
                    vis[ele]=true;
                    q.add(new pair(ele,node));
                }
                else if(ele!=parent){
                    return true;
                }
            }
            
            
        }
        return false;
        
    }
}