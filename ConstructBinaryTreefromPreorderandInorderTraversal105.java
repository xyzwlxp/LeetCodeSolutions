import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class ConstructBinaryTreefromPreorderandInorderTraversal105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderindexMap = new HashMap<>();
		Map<Integer, Integer> preorderindexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderindexMap.put(inorder[i], i);
		}
		for (int i = 0; i < preorder.length; i++) {
			preorderindexMap.put(preorder[i], i);
		}
		return buildTreeUntil(preorder, inorder, 0, 0, preorder.length - 1, inorderindexMap);
	}

	private TreeNode buildTreeUntil(int[] preorder, int[] inorder, int preorderIndex, int inorderStart, int inorderEnd,
			Map<Integer, Integer> inorderindexMap) {
		/*-
		 * [3,9,15,7,20,8,2] 
		 * [15,9,7,3,8,20,2]
		 * 
		 *            3
		 *  15,9,7        8,20,2
		 *   pivot will be the minimum index of left and right subtree in preorder as the preorder traverse the root first.
		 */
		TreeNode node = null;
		if (inorderStart <= inorderEnd) {
			Integer inorderPos = inorderindexMap.get(preorder[preorderIndex]);
			node = new TreeNode(inorder[inorderPos]);
			// the position of left pivot (say 9) will be the preorder position of last
			// pivot(say 3) plus 1
			node.left = buildTreeUntil(preorder, inorder, preorderIndex + 1, inorderStart, inorderPos - 1,
					inorderindexMap);
			// the position of right pivot (say 20) will be the preorder position of last
			// pivot(say 3) plus the length of left subTree (inorderPos - 1 -
			// inorderStart + 1) plus 1
			node.right = buildTreeUntil(preorder, inorder, preorderIndex + inorderPos - inorderStart + 1,
					inorderPos + 1, inorderEnd, inorderindexMap);
		}
		return node;
	}

	public static void main(String[] args) {
		Solution so = new Solution();
		TreeNode tree = so.buildTree(new int[] { 3, 9, 15, 7, 20, 8, 2 }, new int[] { 15, 9, 7, 3, 8, 20, 2 });
		tree.preorderTraverse();
		tree.inorderTraverse();
	}
}
