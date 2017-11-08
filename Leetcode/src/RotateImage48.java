public class RotateImage48 {
    /**
    Given input matrix = 
    [   [1,2,3],
        [4,5,6],
        [7,8,9]     ],
    rotate the input matrix in-place such that it becomes:
    [   [7,4,1],
        [8,5,2],
        [9,6,3]     ]
    */
    public static void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = i; j < col; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i < row; i++){
            for(int j = 0; j < row/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][row-1-j];
                matrix[i][row-1-j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix ={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
