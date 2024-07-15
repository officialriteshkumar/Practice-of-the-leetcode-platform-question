import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Map<Integer, Integer> childParentMap = new HashMap<>();
        
        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal = description[1];
            boolean isLeft = description[2] == 1;
            
            TreeNode parentNode = nodes.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = nodes.getOrDefault(childVal, new TreeNode(childVal));
            
            if (isLeft) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            nodes.put(parentVal, parentNode);
            nodes.put(childVal, childNode);
            childParentMap.put(childVal, parentVal);
        }
        
        TreeNode root = null;
        for (TreeNode node : nodes.values()) {
            if (!childParentMap.containsKey(node.val)) {
                root = node;
                break;
            }
        }
        
        return root;
    }
    
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            result.add(currentNode.val);
            
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        
        return result;
    }
}

