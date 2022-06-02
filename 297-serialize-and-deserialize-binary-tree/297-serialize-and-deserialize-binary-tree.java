/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("# ");
            return;
        }
        sb.append(root.val+" ");
        serialize(root.left,sb);
        serialize(root.right,sb);
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        
        return sb.toString();
    }
    int idx=0;
    public TreeNode deserialize(String []arr) {
        if(idx>=arr.length || arr[idx].equals("#")){
            idx++;
            return null;
        }
        TreeNode root=new TreeNode(Integer.parseInt(arr[idx++]));
        root.left=deserialize(arr);
        root.right=deserialize(arr);
        
        return root;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        
        idx=0;
        String[]arr=data.split(" ");
        return deserialize(arr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));