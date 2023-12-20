package bean;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * 数组构建treebuild
     * @param build
     * @return
     */
    public static TreeNode build(int[] build) {
        TreeNode root = new TreeNode(build[0]);
        build(build, root, 0);
        return root;
    }

    private static void build(int[] build, TreeNode root, int parent) {
        int left = parent * 2 + 1;
        int right = left + 1;
        if (build.length <= left) {
            return;
        }
        if (build[left] != -1) {
            root.left = new TreeNode(build[left]);
            build(build, root.left, left);
        }

        if (build[right] != -1) {
            root.right = new TreeNode(build[right]);
            build(build, root.right, right);
        }
    }
}
