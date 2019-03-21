class Solution {
	public void rotate(int[][] matrix) {
		rotateImage(matrix, 0, matrix.length - 1);
	}

	public void rotateImage(int[][] matrix, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int arr[] = new int[matrix.length];
			for (int i = start; i <= end; i++) {
				arr[i] = matrix[start][i];
			}
			for (int i = end; i >= start; i--) {
				matrix[start][i] = matrix[matrix.length - i - 1][start];
			}
			for (int i = start; i <= end; i++) {
				matrix[i][start] = matrix[end][i];
			}
			for (int i = start; i <= end - 1; i++) {
				matrix[end][i] = matrix[matrix.length - i - 1][end];
			}
			// fill in the special last character
			for (int i = start; i <= end; i++) {
				matrix[i][end] = arr[i];
			}
		}
		rotateImage(matrix, start + 1, end - 1);
	}
}
