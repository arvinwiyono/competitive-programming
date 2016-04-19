import java.util.*;
public class EExcellence{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in);
		int numStudent = sc.nextInt();

		int [] students = new int [numStudent];

		int [] pairsPoint = new int [numStudent/2];

		for(int i = 0; i < numStudent; i++){
			students[i] = sc.nextInt();
		}
		Arrays.sort(students);

		int pb = students.length-1;
		for(int pf = 0; pf < numStudent/2; pf++){
			pairsPoint[pf] = students[pf]+students[pb];
			pb--;
		}

		Arrays.sort(pairsPoint);
		System.out.println(pairsPoint[0]);
	}
}