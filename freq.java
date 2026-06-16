import java.util.Scanner;
public class freq{
	public static void main(String[] args){
		String str;
		char a;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		str=sc.nextLine();
		System.out.println("enter a a charcter in the string to find the freq");
		a=sc.next().charAt(0);
		char charcopy=Character.toLowerCase(a);
		int f=0;
		String strcopy=str;
		for(int i=0;i<str.length();i++){
			if(charcopy==str.charAt(i)){
				f++;
			}
		}
		System.out.println("the frequency of the given character "+a+" in string "+strcopy+" is "+f);
	}
}