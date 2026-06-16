import java.util.Scanner;
public class matrix{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of rows of matrix a");
		int rowa=sc.nextInt();
		System.out.println("enter the number of columns of matrix a");
		int cola=sc.nextInt();
		System.out.println("enter the number of rows of matrix b");
		int rowb=sc.nextInt();
		System.out.println("enter the number of columns of matrix b");
		int colb=sc.nextInt();
		int[][] matrixa=new int[rowa][cola];
		int[][] matrixb=new int[rowb][colb];
		int[][] result=new int[rowa][colb];
		System.out.println("enter the elements of matrix a:");
		for(int i=0;i<rowa;i++)
			for(int j=0;j<cola;j++)
				matrixa[i][j]=sc.nextInt();
		
		System.out.println("enter the elements of matrix b:");
		for(int i=0;i<rowb;i++)
		for(int j=0;j<colb;j++)
		matrixb[i][j]=sc.nextInt();
			
		for(int i=0;i<rowa;i++)
		for(int j=0;j<colb;j++){
		result[i][j]=0;
	    for(int k=0;k<cola;k++)
		result[i][j]+=matrixa[i][k]*matrixb[k][j];
		}
		System.out.println("resultant matrix");
		for(int i=0;i<rowa;i++){
			for(int j=0;j<colb;j++)
				System.out.print(result[i][j]+" ");		
		}
	}
}
	
			
		
		
		
