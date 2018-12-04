/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/
import java.util.LinkedList;
import java.util.List;

class SpiralMatrix54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> newList = new LinkedList<>();
		if (matrix.length == 0) {
			return newList;
		}
		int size = (matrix[0].length) * (matrix.length);
		System.out.println(size);
		int leftBound = 0;
		int rightBound = matrix[0].length - 1;
		int topBound = 0;
		int bottomBound = matrix.length - 1;
		int horiIndex = 0;
		int verIndex = 0;
		while (true) {
			while (horiIndex <= rightBound) {
				newList.add(matrix[verIndex][horiIndex]);
				horiIndex++;
			}
			if (newList.size() == size) {
				break;
			}
			horiIndex--;
			verIndex++;
			topBound++;
			while (verIndex <= bottomBound) {
				newList.add(matrix[verIndex][horiIndex]);
				verIndex++;
			}
			if (newList.size() == size) {
				break;
			}
			verIndex--;
			horiIndex--;
			rightBound--;
			while (horiIndex >= leftBound) {
				newList.add(matrix[verIndex][horiIndex]);
				horiIndex--;
			}
			if (newList.size() == size) {
				break;
			}
			horiIndex++;
			verIndex--;
			bottomBound--;
			while (verIndex >= topBound) {
				newList.add(matrix[verIndex][horiIndex]);
				verIndex--;
			}
			if (newList.size() == size) {
				break;
			}
			verIndex++;
			horiIndex++;
			leftBound++;
		}
		return newList;
	}
}
