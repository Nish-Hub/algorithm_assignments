
public class MatrixMultiplication {
public static void main(String[] args) {
	int[][] prod = null;
	int[][] r={ {1,2},{1,2}};
	int[][] c={ {3,4},{3,4}};
	
	for(int i=0;i<r.length;i++)
	{
		for(int j=0;j<c.length;j++)
		{
			for(int k=0;k<r.length;k++)
			prod[i][j]+=r[i][k]*c[k][j];
		}
	}
}
}
