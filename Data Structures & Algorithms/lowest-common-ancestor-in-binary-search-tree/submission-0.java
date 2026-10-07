/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean found(TreeNode root, TreeNode n){
        if(root==null) return false;
        if(root==n) return true;
        return found(root.left,n)|found(root.right,n);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(found(root.left,p) & found(root.left,q)) return lowestCommonAncestor(root.left,p,q);
        else if(found(root.right,p) & found(root.right,q)) return lowestCommonAncestor(root.right,p,q);
        else return root;
    }
}
