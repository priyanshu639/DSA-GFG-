/*
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
*/

class Solution {
    public Node bst(int[]arr,int low,int high){
        if(low>high) return null;
        int mid = (high+low)/2;
        Node root = new Node(arr[mid]);
        root.left = bst(arr,low,mid-1);
        root.right = bst(arr,mid+1,high);
        return root;
    }
    public Node sortedArrayToBST(int[] arr) {
        // code here
        return bst(arr,0,arr.length-1);
    }
}