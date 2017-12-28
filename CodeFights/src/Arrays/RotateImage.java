package Arrays;

/**
 * Created by Tien on 12/28/2017.
 *
 * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).

 Example

 For

 a =    [[1, 2, 3],
        [4, 5, 6],
        [7, 8, 9]]
 the output should be

 rotateImage(a) =
 [[7, 4, 1],
 [8, 5, 2],
 [9, 6, 3]]
 */
public class RotateImage {

    /**
     * O(n) Time complexity and O(1) Space;
     * @param a
     * @return
     */
    int[][] rotateImage1(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i; j < a.length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }

        for(int i = 0; i < a.length; i++) {
            System.out.println();
            for(int j = 0; j < a.length; j++) {
                System.out.print(a[i][j] + " ");
            }
        }

        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a.length/2; j++) {
                int temp = a[i][j];
                a[i][j] = a[i][a.length - j - 1];
                a[i][a.length -j -1] = temp;
            }
        }
        return a;
    }

    /**
     * O(n) Time complexity and O(1) Space
     * @param a
     * @return
     */
    int[][] rotateImage2(int[][] a) {
        int n = a.length;
        for (int layer = 0; layer < Math.ceil(n / 2.0); ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for(int i = first; i < last; ++i) {
                int offset = i - first;
                int top = a[first][i]; // save top

                // left -> top
                a[first][i] = a[last-offset][first];

                // bottom -> left
                a[last-offset][first] = a[last][last - offset];

                // right -> bottom
                a[last][last - offset] = a[i][last];

                // top -> right
                a[i][last] = top; // right <- saved top
            }
        }
        return a;
    }

}
