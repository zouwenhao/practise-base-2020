package cn.zou.leetcode.type_tree.digui;

public class BFT {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int v) {
            val = v;
        }
    }

    public TreeNode getRoot(int[] nodes) {
        return genereteTree(nodes, 0, nodes.length - 1);
    }

    public TreeNode genereteTree(int[] nodes, int left, int right) {
        if (nodes == null) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nodes[left]);
        }
        if (left > right) {
            return null;
        }
        int middle = left - 1; // 初始化成数组区间外的索引，而非left，应对区间内所有元素都比根节点大的情况，从而走到left>right，构建出空的左子树
        for (int i = left; i < right; i++) {
            if (nodes[i] < nodes[right]) {
                middle = i;
            }
        }
        TreeNode root = new TreeNode(nodes[right]);
        root.left = genereteTree(nodes, left, middle);
        root.right = genereteTree(nodes, middle + 1, right - 1);
        return root;
    }

    public static void main(String[] args) {
        BFT bft = new BFT();
        TreeNode root = bft.getRoot(new int[]{2, 4, 3, 6, 8, 7, 5});
        System.out.println(root.val);
        return;
    }
}
