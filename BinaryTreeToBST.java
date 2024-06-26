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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedNodes = new ArrayList<>();
        inorderTraversal(root, sortedNodes);
        return sortedArrayToBST(sortedNodes, 0, sortedNodes.size() - 1);
    }

    // Helper function to perform inorder traversal and collect nodes in sorted order
    private void inorderTraversal(TreeNode root, List<Integer> sortedNodes) {
        if (root == null) return;
        inorderTraversal(root.left, sortedNodes);
        sortedNodes.add(root.val);
        inorderTraversal(root.right, sortedNodes);
    }

    // Helper function to convert sorted array to BST
    private TreeNode sortedArrayToBST(List<Integer> sortedNodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedNodes.get(mid));
        node.left = sortedArrayToBST(sortedNodes, start, mid - 1);
        node.right = sortedArrayToBST(sortedNodes, mid + 1, end);
        return node;
    }
}

public class BinaryTreeToBST {

    // Insert a node into the BST
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // Function to convert array representation to BST
    public TreeNode arrayToBST(Integer[] arr) {
        TreeNode root = null;
        for (Integer val : arr) {
            if (val != null) {
                root = insertIntoBST(root, val);
            }
        }
        return root;
    }

    // Level order traversal to print tree
    public void printLevelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeToBST solution = new BinaryTreeToBST();

        // Example 1
        Integer[] input1 = {1, null, 2, null, 3, null, 4, null, null};
        TreeNode root1 = solution.arrayToBST(input1);
        solution.printLevelOrder(root1); // Output could be [1, null, 2, null, 3, null, 4]
        System.out.println();

        // Example 2
        Integer[] input2 = {2, 1, 3};
        TreeNode root2 = solution.arrayToBST(input2);
        solution.printLevelOrder(root2); // Output [2, 1, 3]
        System.out.println();

        // Balancing the BST (for demonstration)
        Solution sol = new Solution();
        TreeNode balancedRoot1 = sol.balanceBST(root1);
        solution.printLevelOrder(balancedRoot1);
        System.out.println();

        TreeNode balancedRoot2 = sol.balanceBST(root2);
        solution.printLevelOrder(balancedRoot2);
        System.out.println();
    }
}
    

