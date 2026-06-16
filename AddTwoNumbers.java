import java.util.Scanner;
public class AddTwoNumbers{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		System.out.print("enter the first integer: ");
		int num1=sc.nextInt();
		System.out.print("enter the second integer: ");
		int num2=sc.nextInt();
		int sum=num1+num2;
		System.out.println("the sum is: "+sum);
	}
}
