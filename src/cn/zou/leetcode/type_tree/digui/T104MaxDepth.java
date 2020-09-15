package cn.zou.leetcode.type_tree.digui;

import cn.zou.leetcode.type_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class T104MaxDepth {

    public static void main(String[] args) {
        T104MaxDepth t104MaxDepth = new T104MaxDepth();
        TreeNode root = new TreeNode();
        TreeNode root1 = new TreeNode();
        TreeNode root2 = new TreeNode();
        TreeNode root21 = new TreeNode();
        TreeNode root22 = new TreeNode();
        root.left = root1;
        root.right = root2;
        root2.left = root21;
        root2.right = root22;
        System.out.println(t104MaxDepth.maxDepthBFS(root));
    }

    /**
     * 递归DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(height)，极端情况下O(n)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * BFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)，每层节点的最大数量，最优情况下O(1)
     * @return
     */
    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>(); //将所有节点保存在队列中
        queue.offer(root); //添加根节点
        while (!queue.isEmpty()) {
            int size = queue.size(); //记录当前层数的节点个数
            while (size > 0) { //将每个节点出列，并将左右子树添加到队列中
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                size--;
            }
            result++; //当前层的节点处理完，层数+1
        }
        return result;
    }

}
