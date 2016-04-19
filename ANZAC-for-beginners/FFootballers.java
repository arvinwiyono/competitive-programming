import java.util.*;
public class FFootballers{
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);

		String name = sc.next();
		int age = sc.nextInt();
		int weight = sc.nextInt();

		String output = name + " ";
		if(isSenior(age, weight)){
			output += "Senior";
		}
		else{
			output += "Junior";
		}
		System.out.println(output);
	}

	static boolean isSenior(int a, int w){
		if(a > 17 || w >= 80){
			return true;
		}
		return false;
	}
}