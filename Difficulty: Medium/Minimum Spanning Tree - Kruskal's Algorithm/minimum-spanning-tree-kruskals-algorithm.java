import java.util.*;

class Solution {

    static class Pair implements Comparable<Pair> {
        int u, v, w;

        Pair(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Pair other) {
            return this.w - other.w;
        }
    }

    static int parent[];
    static int size[];

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); 
    }

    public static boolean union(int u, int v) {
        int ul_u = find(u);
        int ul_v = find(v);

        if (ul_u == ul_v) return false;

        if (size[ul_u] > size[ul_v]) {
            parent[ul_v] = ul_u;
            size[ul_u] += size[ul_v];
        } else {
            parent[ul_u] = ul_v;
            size[ul_v] += size[ul_u];
        }

        return true;
    }

    static int kruskalsMST(int n, int[][] edges) {

        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        List<Pair> edgeList = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new Pair(edges[i][0], edges[i][1], edges[i][2]));
        }

        Collections.sort(edgeList);

        int weight = 0;

        for (Pair e : edgeList) {   
            if (union(e.u, e.v)) {
                weight += e.w;
            }
        }

        return weight;
    }
}