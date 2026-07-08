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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res=new ArrayList<>();
        dfsSerialize(root,res);
        return String.join(",",res);
    }
    public void dfsSerialize(TreeNode root, List<String> res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left,res);
        dfsSerialize(root.right,res);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] ind= new int[1];
        String[] val=data.split(",");
        return dfsDeserialize(val,ind);
    }

    public TreeNode dfsDeserialize(String[] val,int[] ind){
        if(val[ind[0]].equals("N")){
            ind[0]++;
            return null;
        }
        TreeNode node= new TreeNode(Integer.parseInt(val[ind[0]]));
        ind[0]++;
        node.left= dfsDeserialize(val,ind);
        node.right=dfsDeserialize(val,ind);
        return node;

    }
}
