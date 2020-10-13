import java.util.Arrays;
//336208657
public class MaxSubRectangle {

	int mat [][];
	int maxSum,ILeft,JLeft,IRight,JRight,minSum,ILeftmin,JLeftmin,IRightmin,JRightmin = 0;
	int minus_infinity = -1000000;
	public int getMaxSum() {
		return returnRightSum();
	}
	public int getILeft()  {
		if(getMaxSum() == maxSum) {
			return ILeft; 
		}
		return ILeftmin;
	}
	public int getJLeft()  { 
		if(getMaxSum() == maxSum) {
			return JLeft; 
		}
		return JLeftmin;
	}
	public int getIRight() { 
		if(getMaxSum() == maxSum) {
			return IRight; 
		}
		return IRightmin;
	}
	public int getJRight() { 
		if(getMaxSum() == maxSum) {
			return JRight; 
		}
		return JRightmin;
	}
	public MaxSubRectangle(int mat[][]){
		int i = 0;
		int j = 0;
		int r = 0;
		int c = 0;
		int tempr,tempc = 0;
		for (int k = 0; k < mat.length; k++) {
			tempr = mat[k][0];
			if(tempr > r) {
				r = tempr;
			}
			tempc = mat[k][1];
			if(tempc > c)
			c = tempc;
		}
		int arr[][]= new int[r+1][c+1];
		for (int k = 0; k < arr.length; k++) {
			for (int k2 = 0; k2 < arr[i].length; k2++) {
				arr[k][k2] = minus_infinity;
			}
		}
		for (int k = 0; k < mat.length; k++) {
			i = mat[k][0];
			j = mat[k][1];	
			arr[i][j] = mat[k][2]; 	
		}

		int length = arr.length;
		int width = arr[0].length;
		int [][] helpMat = initHelpMat(arr);
		getMaxSumAndIndexes(helpMat,length,width);

	}

	public int[][] initHelpMat(int arr[][]){
		int m = arr.length; 
		int n = arr[0].length; 
		int helpMat[][] = new int[m+1][n]; 

		for(int k = 0; k < m; k++) { 
			for(int l = 0; l < n; l++) { 
				helpMat[k+1][l] = helpMat[k][l] + arr[k][l]; 
			} 
		}

		return helpMat;
	}

	public void getMaxSumAndIndexes(int helpMat[][],int m,int n) {
		maxSum = Integer.MIN_VALUE; 
		minSum = Integer.MIN_VALUE; 
		for(int start_row = 0; start_row < m; start_row++) { 
			for(int row = start_row; row < m; row++){ 
				int tempSum = 0; 
				int current_CStart = 0; 
				for(int column = 0; column < n; column++) { 
					tempSum += helpMat[row+1][column] - helpMat[start_row][column]; 
					if(tempSum < 0) { 
						if(minSum < tempSum) { 
							minSum = tempSum; 
							ILeftmin = start_row; 
							IRightmin = row; 
							JLeftmin = current_CStart; 
							JRightmin = column; 
						} 
						tempSum = 0; 
						current_CStart = column+1; 
					} 
					else if(maxSum < tempSum) { 
						maxSum = tempSum; 
						ILeft = start_row; 
						IRight = row; 
						JLeft = current_CStart; 
						JRight = column; 
					} 
				} 
			} 
		}

	}
	public int returnRightSum() {
		if(maxSum != Integer.MIN_VALUE) {
			return  maxSum;
		}
		return minSum;
	}
	public static void main(String[] args) { 
//		int[][] mat = {
//				{0,3,1},
//				 {1,2,1},
//				 {1,3,2},
//				 {1,4,-4},
//				 {2,1,2},
//				 {2,2,-3},
//				 {2,3,3},
//				 {2,4,3},
//				 {2,5,1},
//				 {3,0,-2},
//				 {3,1,10},
//				 {3,2,9},
//				 {3,3,-2},
//				 {3,4,4},
//				 {3,5,5},
//				 {3,6,-11}
//
//		};
		
		int mat[][] = {{0, 1, -24},
				{0, 9, 3},
				{0, 14, -50}, 
				{1, 0, -57}, 
				{1, 2, -11}, 
				{1, 4, -31}, 
				{1, 12, 20},
				{2, 2, -86}, 
				{2, 5, -95}, 
				{2, 7, -16},
				{2, 8, 47}, 
				{2, 10, 31},
				{3, 3, 41}, 
				{3, 6, -74}, 
				{3, 8, 4},
				{3, 13, -86},
				{4, 5, 17}, 
				{4, 7, -4},
				{4, 11, -27},
				{4, 14, -26}, 
				{5, 1, -17}, 
				{5, 3, 86}, 
				{5, 4, -17},
				{5, 6, -99},
				{5, 11, 85}, 
				{6, 0, 59}, 
				{6, 3, -52}, 
				{6, 6, 19},
				{6, 7, 22}, 
				{6, 10, -19}, 
				{6, 11, -11},
				{7, 3, 67}, 
				{7, 5, -17}, 
				{7, 10, -3}, 
				{8, 1, -95}, 
				{8, 4, -81}, 
				{8, 5, -65}, 
				{8, 8, -41}, 
				{8, 9, 93},
				{8, 10, 14}, 
				{8, 12, -94},
				{8, 13, 68}, 
				{8, 14, -33},
				{9, 5, 83}, 
				{9, 10, -24},
				{9, 12, -56}, 
				{9, 13, 92}
		
		
		};
		MaxSubRectangle a = new MaxSubRectangle(mat);
		System.out.println(a.getMaxSum());
		System.out.println(a.getILeft()+","+a.getJLeft());
		System.out.println(a.getIRight()+","+a.getJRight());
	}

}