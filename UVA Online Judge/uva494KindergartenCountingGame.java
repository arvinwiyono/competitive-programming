import java.util.*;

public class uva494KindergartenCountingGame{

	public static void main(String []args){

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String input = sc.nextLine();

			boolean wordMode = false;
			int total = 0;
			for(int i = 0; i < input.length(); i++){
				
				int ascii = (int) input.charAt(i);
				if(isLetter(ascii)){
					wordMode = true;
				}
				else{
					if(wordMode){
						wordMode =false;
						total++;
					}
				}
			}
			System.out.println(total);
		}	
	}

	static boolean isLetter(int ascii){
		if( (ascii >= 65 && ascii <= 90) || (ascii >= 97 && ascii <= 122) ){
			return true;
		} 
		return false;
	}
}