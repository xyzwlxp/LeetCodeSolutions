/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> listlist = new ArrayList<List<Integer>>();
		doSpatialTraverse(root, 0, listlist);
        return listlist;
    }

	private void doSpatialTraverse(TreeNode treeNode, int level, List<List<Integer>> listlist) {
		if (treeNode != null) {
			if (listlist.size() == level) {
				List<Integer> list = new LinkedList<>();
				list.add(treeNode.val);
				listlist.add(list);
			} else {
				List<Integer> list = listlist.get(level);
				list.add(treeNode.val);
			}
			doSpatialTraverse(treeNode.left, level + 1, listlist);
			doSpatialTraverse(treeNode.right, level + 1, listlist);
		}
	}
}
