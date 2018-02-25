import java.util.*;

public class uva10783OddSum{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt();
		
		for(int num = 1; num <= numTest; num++){
			int num1 = sc.nextInt(), num2 = sc.nextInt();
			int [] numbers = {num1, num2};
			Arrays.sort(numbers);
			int sum = 0;
			for(int i = numbers[0]; i <= numbers[1]; i++ ){
				if(isOdd(i)){
					sum += i;
				}
			}
			System.out.println("Case " + num + ": " + sum);
		}
	}

	public static boolean isOdd(int num){
		return num % 2 == 1;
	}
}