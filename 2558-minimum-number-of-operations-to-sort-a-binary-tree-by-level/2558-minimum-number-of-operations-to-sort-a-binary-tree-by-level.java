import java.util.*;

class Solution {
    // Method to find the index of an element in an array
    private int indexOf(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    // Method to swap two elements in an array
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to calculate the minimum swaps required to sort the array
    private int minSwaps(int[] arr, int N) {
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        Arrays.sort(temp);

        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (visited[i] || arr[i] == temp[i]) {
                continue;
            }

            int cycleSize = 0;
            int x = i;

            while (!visited[x]) {
                visited[x] = true;
                x = indexOf(arr, temp[x]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                ans += (cycleSize - 1);
            }
        }
        return ans;
    }

    // Main method to calculate the minimum operations on the binary tree
    public int minimumOperations(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                arr[i] = curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            count += minSwaps(arr, size);
        }
        return count;
    }
}
