public class BstFromPreorder {

    public static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + (this.isLeaf() ? "" : ("," + left + "," + right));
        }

        private boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        final TreeNode tree = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            this.insert(tree, preorder[i]);
        }
        return tree;
    }

    private void insert(TreeNode node, int newVal) {
        if (newVal < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(newVal);
            } else {
                this.insert(node.left, newVal);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode(newVal);
            } else {
                this.insert(node.right, newVal);
            }
        }
    }
}
