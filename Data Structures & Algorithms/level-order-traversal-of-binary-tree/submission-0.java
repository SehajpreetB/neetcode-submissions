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
    List<List<Integer>> ans=new ArrayList<>();
    public void util(TreeNode root,int level){
        if(root==null) return;
        if(ans.size()<level+1){
            List<Integer> a=new ArrayList<>();
            ans.add(a);
        }
        ans.get(level).add(root.val);
        util(root.left,level+1);
        util(root.right,level+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        util(root,0);
        return ans;
    }
}
