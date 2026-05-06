/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case
        // If root is null, there is no node to search.
        if( root == null){
            return null;
        }
        // If current node is either p or q, return it
        // A node can an ancestor of itself
        if (root == p || root == q){
            return root;
        }
        // Search for p and q in the left subtree.
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // Search for p and q in the right subtree.
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // If both left and right are non null, it means p and q are found on different sides,
        // so current root is their lowest common ancestor
        if( left != null && right != null){
            return root;
        }
        // If only one side is non-null, return that side.
        // If both are null, this return null.
        return left != null ? left : right;
        
    }
}