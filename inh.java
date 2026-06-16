import java.util.Scanner;
public class inh{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		officer off=new officer();
		manager man=new manager();
		System.out.println("enter 1 for officer or 2 for manager");
		int c=sc.nextInt();
		sc.nextLine();
		if(c==1){
			System.out.println("OFFICER DETAILS");
			off.name=sc.nextLine();
			off.age=sc.nextInt();
			sc.nextLine();
			off.salary=sc.nextInt();
			sc.nextLine();
			off.specification=sc.nextLine();
			off.displayofficer();
		}
		else if(c==2){
			System.out.println("MANAGER DETAILS");
			man.name=sc.nextLine();
			man.age=sc.nextInt();
			sc.nextLine();
			man.salary=sc.nextInt();
			sc.nextLine();
			man.department=sc.nextLine();
			man.displaymanager();
		}
		else{
			System.out.println("error");
		}
	}
}
class employee{
	String name;
	int age;
	int salary;
	public void printsalary(){
		System.out.println("salary:"+salary);
	}
}
class officer extends employee{
	String specification;
	void displayofficer(){
		System.out.println(" ");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("salary:"+salary);
		System.out.println("specification:"+specification);
	}
}
class manager extends employee{
	String department;
	void displaymanager(){
		System.out.println(" ");
		System.out.println("name:"+name);
		System.out.println("age:"+age);
		System.out.println("salary:"+salary);
		System.out.println("department:"+department);
	}
}
		