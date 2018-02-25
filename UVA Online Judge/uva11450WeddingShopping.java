import java.util.*;
public class uva11450WeddingShopping {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int caseNo = 0; caseNo < N; caseNo++){
			int M = sc.nextInt();
			int C = sc.nextInt();
			int [][] garments = new int [C][]; 
			for(int i = 0; i < C; i++){
				int numModel = sc.nextInt();
				garments[i] = new int [numModel];
				for(int j = 0; j < numModel; j++){
					garments[i][j] = sc.nextInt();
				}
			}
			
			
			//Create solutions
			boolean [][] solutions = new boolean [C][M+1];
			
			//Fill in the base case
			for(int i = 0; i < garments[0].length; i++){
				if(M-garments[0][i] >= 0){
					solutions[0][M-garments[0][i]] = true;
				}
			}
//			for(boolean [] array: solutions){
//				System.out.println(Arrays.toString(array));
//			}
			
			//For each row
			for(int r = 1; r < solutions.length; r++){
				//for each model
				for(int g = 0; g < garments[r].length; g++){
					//for each col
					for(int c = 0; c < solutions[r-1].length; c++){
						if(solutions[r-1][c] == true){
							int next = c - garments[r][g];
							if(next >= 0){
								solutions[r][next]= true;
							}
						}
					}
				}
			}
			
			
			int remainingMoney = 0; boolean found = false;
			for(int i = 0; i < solutions[0].length; i++){
				if(solutions[solutions.length-1][i] == false){
					remainingMoney++;
				}
				else{found = true;break;}
			}
			
			if(found){
				System.out.println(M-remainingMoney);
			}
			else{
				System.out.println("no solution");
			}
		}
	}
}
