/*
 * bad approach using valid paren or not
 */
class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> parenList = new LinkedList<>();
		generateParen(parenList, "(", n);

		return parenList;
	}

	public void generateParen(List<String> parenList, String curren, int n) {
		if (curren.length() > n * 2) {
			return;
		}
		if (curren.length() == n * 2 && isValid(curren, n)) {
			parenList.add(curren);
			return;
		}
		if (!isValid(curren, n)) {
			return;
		}

		generateParen(parenList, curren + '(', n);
		generateParen(parenList, curren + ')', n);
	}

	public boolean isValid(String s, int n) {
		int leftCount = 0;
		int rightCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else if (s.charAt(i) == ')') {
				rightCount++;
			}
			if (rightCount > leftCount || leftCount > n) {
				return false;
			}
		}
		return true;
	}
}
