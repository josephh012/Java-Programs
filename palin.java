import java.util.Scanner;
public class palin{
	public static void main(String[] args){
		String str="";
		String reverseStr="";
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		str=sc.nextLine();
		int strLength=str.length();
		for(int i=(strLength-1);i>=0;--i){
			reverseStr=reverseStr+str.charAt(i);
		}
		if(str.toLowerCase().equals(reverseStr.toLowerCase())){
			System.out.println(str+" is palindrome");
		}
		else{
			System.out.println(str+" not a palindrome");
		}
	}
}