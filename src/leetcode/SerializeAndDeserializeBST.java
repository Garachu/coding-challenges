package leetcode;

public class SerializeAndDeserializeBST {

    public static void main(String args[]) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        System.out.println();

//        String serialize = serialize(root);
//        System.out.println(serialize);
//        TreeNode deserialize = deserialize(serialize);
//        System.out.println(serialize(deserialize));

//        String serialize = serialize(null);
//        System.out.println(serialize);
//        TreeNode deserialize = deserialize(serialize);
//        System.out.println(serialize(deserialize));

        TreeNode deserialize = deserialize("2,1");
        System.out.println(serialize(deserialize));

    }

    // Encodes a tree to a single string.
    static String serialize(TreeNode root) {
        if (root == null) return "";
        String s = preOrder(root, new StringBuilder());
        return s.substring(0, s.length() - 1);
    }

    static String preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return "";
        sb.append(root.val);
        sb.append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    static TreeNode deserialize(String data) {
        if(data.trim().isEmpty()) return null;
        String[] split = data.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i].trim());
        }
        return constructBstFromPreOrder(nums, 0, (nums.length - 1));
    }

    static TreeNode constructBstFromPreOrder(int[] nums, int l, int r) {
        if (l > r) return null;
        // This is definately the root
        TreeNode root = new TreeNode(nums[l]);
        if (l == r) {
            return root;
        }
        // the next index after root
        int indx = l + 1;
        while (indx <= r && nums[indx] < root.val) {
            indx++;
        }
        root.left = constructBstFromPreOrder(nums, l + 1, indx - 1);
        root.right = constructBstFromPreOrder(nums, indx, r);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
