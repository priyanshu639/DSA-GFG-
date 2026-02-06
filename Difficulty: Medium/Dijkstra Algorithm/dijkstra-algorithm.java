class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int distance;
        Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
        public int compareTo(Pair other){
            return this.distance-other.distance;
        }
        
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u, w));

        }
        int cost[]=new int[V];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        PriorityQueue<Pair>pq=new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(pq.size()>0){
            Pair top=pq.remove();
            for(Pair ele:adj.get(top.node)){
                int totaldistance=top.distance+ele.distance;
                if(totaldistance<cost[ele.node]){
                    cost[ele.node]=totaldistance;
                    pq.add(new Pair (ele.node,totaldistance));
                }
            }
        }
        return cost;
        
    }
}