import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {
    /**
     * Vestigium means "trace" in Latin. In this problem we work with Latin squares and matrix traces.
     *
     * The trace of a square matrix is the sum of the values on the main diagonal (which runs from the upper left to the lower right).
     *
     * An N-by-N square matrix is a Latin square if each cell contains one of N different values, and no value is repeated within a row or a column. In this problem, we will deal only with "natural Latin squares" in which the N values are the integers between 1 and N.
     *
     * Given a matrix that contains only integers between 1 and N, we want to compute its trace and check whether it is a natural Latin square. To give some additional information, instead of simply telling us whether the matrix is a natural Latin square or not, please compute the number of rows and the number of columns that contain repeated values.
     *
     * Input
     * The first line of the input gives the number of test cases, T. T test cases follow. Each starts with a line containing a single integer N: the size of the matrix to explore. Then, N lines follow. The i-th of these lines contains N integers Mi,1, Mi,2 ..., Mi,N. Mi,j is the integer in the i-th row and j-th column of the matrix.
     *
     * Output
     * For each test case, output one line containing Case #x: k r c, where x is the test case number (starting from 1), k is the trace of the matrix, r is the number of rows of the matrix that contain repeated elements, and c is the number of columns of the matrix that contain repeated elements.
     *
     * Limits
     * Test set 1 (Visible Verdict)
     * Time limit: 20 seconds per test set.
     * Memory limit: 1GB.
     * 1 ≤ T ≤ 100.
     * 2 ≤ N ≤ 100.
     * 1 ≤ Mi,j ≤ N, for all i, j.
     *
     *
     * Time Complexity - O(N^2)
     * Space Complexity - O(N) for the hashset
     **/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int limit = scan.nextInt();
        for(int testcase = 0;testcase < limit ;++testcase) {
            int n = scan.nextInt();
            int[][] mat = new int[n][n];
            for(int i=0;i<n;++i) {
                for(int j=0;j<n;++j) {
                    mat[i][j]=scan.nextInt();
                }
            }
            int[] result = vestigium(mat);
            System.out.print("Case #"+(testcase+1)+": ");
            for(int i=0;i<3;++i) {
                System.out.print(result[i]+" ");
            }
            System.out.println();
        }
    }

    public static int[] vestigium(int[][] mat) {
        int[] result = new int[3];
        for(int i=0;i<mat.length;++i) {
            result[0] += mat[i][i];
        }

        HashSet<Integer> set;
        for(int r=0;r<mat.length;++r) {
            set = new HashSet<>();
            for(int c=0;c<mat.length;++c) {
                if(set.contains(mat[r][c])) {
                    result[1]++;
                    break;
                }else{
                    set.add(mat[r][c]);
                }
            }
        }

        for(int c=0;c<mat.length;++c) {
            set = new HashSet<>();
            for(int r=0;r<mat.length;++r) {
                if(set.contains(mat[r][c])) {
                    result[2]++;
                    break;
                }else{
                    set.add(mat[r][c]);
                }
            }
        }
        return result;
    }
}