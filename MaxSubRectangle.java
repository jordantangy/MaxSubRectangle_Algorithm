import java.util.Arrays;

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
		int r = mat[mat.length-1][0]+1;
		int c = mat[mat.length-1][1]+1;
		int arr[][]= new int[r][c];
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

}