import java.util.*;

public class AAutomatedCheckingMachine{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int [] array1 = new int[5];
		int [] array2 = new int[5];
		for(int i = 0; i < 5; i++){
			array1[i] = sc.nextInt();
		}
		for(int i = 0; i < 5; i++){
			array2[i] = sc.nextInt();
		}
		boolean compatible = true;
		for(int i = 0; i < array1.length; i++){
			if(Math.abs(array1[i] - array2[i]) == 0){
				compatible = false;
				break;
			}
		}
		if(compatible){System.out.println("Y");}
		else{System.out.println("N");}

	}
}

/* TEST CASE
1 1 0 1 0
0 0 1 0 1

1 0 0 1 0
1 0 1 1 0
*/