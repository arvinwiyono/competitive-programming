import java.util.*;
public class DDesertBitMap{
	
	static Scanner sc = new Scanner(System.in);

	public static void main (String [] args){
		
		int r, c;

		// get pattern
		r = sc.nextInt(); c = sc.nextInt();
		char [][] pattern = getInput(r, c, new char [r][c]);

		// get map
		r = sc.nextInt(); c = sc.nextInt();
		char [][] map = getInput(r, c, new char [r][c]);

		// for( char [] chars : map){
		// 	System.out.println(Arrays.toString(chars));
		// }
		int total = 0;
		for(int i = 0; i <= map.length - pattern.length; i++){
			for(int j = 0; j <= map[0].length - pattern[0].length; j++){
				
				// System.out.println("Traverse " + i + " , " + j);

				boolean same = true;
				for(int k = 0; k < pattern.length; k++){
					for(int l = 0; l < pattern[k].length; l++){
						// System.out.println(pattern [k][l] + " Check against " + (k+i) + " " + (l+j) + " " + map[k+i][l+j]);
						if(pattern[k][l] != map[k+i][l+j] && pattern[k][l] == '#'){
							same = false;
							break;
						}
					}
					if(!same){
						break;
					}
				}
				if(same){
					// System.out.println("GOTCHA");
					total++;
				}

			}
		}
		System.out.println(total);
	}

	static char [][] getInput(int r, int c, char[][] array){
		for(int i = 0; i < r; i++){
			String input = sc.next();
			for(int j = 0; j < c; j++){
				array[i][j] = input.charAt(j);
			}
		}
		return array;
	}
}