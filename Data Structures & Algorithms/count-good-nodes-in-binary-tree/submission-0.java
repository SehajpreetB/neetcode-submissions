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
    int count=0;
    public void util(TreeNode root,int maxVal){
        if(root==null) return;
        if(root.val >=maxVal) count++;
        maxVal=Math.max(maxVal,root.val);
        util(root.left,maxVal);
        util(root.right,maxVal);
    }
    public int goodNodes(TreeNode root) {
        util(root,-101);
        return count;
    }
}
