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
    // Helper class to store two things together:
    // 1. node = LCA of deepest leaves in this subtree
    // 2. depth = max depth of this subtree
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }
    private Pair dfs(TreeNode root){
        //Base case: empty subtree has depth 0 and no LCA
        if(root == null){
            return new Pair(null, 0);
        }
        // Recursively get deepest information from left and right subtree
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        // If left and right depths are equal, deepest leaves exist on both sides, so current root is their LCA
        if(left.depth == right.depth){
            return new Pair(root, left.depth + 1);
        }
        // If left subtree is deeper LCA must be inside the left subtree
        if(left.depth > right.depth){
            return new Pair(left.node, left.depth + 1);
        }
        // If right subtree is deeper, LCA must be inside the right subtree 
        return new Pair(right.node, right.depth + 1);
    }
}