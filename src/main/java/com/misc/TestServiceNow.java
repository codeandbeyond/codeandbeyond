import junit.framework.TestSuite;

public class TestServiceNow {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},
                {4,5,6},
                {7,8,9}};
        TestServiceNow test = new TestServiceNow();
        test.roatetMatrix(mat);
    }
    public void roatetMatrix(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i] ;
                mat[j][i] = temp;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-1-j];
                mat[i][n-1-j] = temp;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(" "+mat[i][j]);
            }
            System.out.println();
        }
    }
}
