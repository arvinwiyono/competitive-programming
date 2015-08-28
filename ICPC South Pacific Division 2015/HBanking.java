import java.util.*;
public class HBanking{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		String PIN = sc.nextLine();
		String pattern = sc.nextLine();
		String numberString = "";
		
		int pointer = 0;
		for(char c : pattern.toCharArray()){
			if(c == Character.toLowerCase(c)){
				try{
					String sub = PIN.substring(pointer, pointer + ((int) c - 96));
					numberString += sub;
				}
				catch(Exception e){}
			}
			pointer += (int)Character.toUpperCase(c) - 64;
			if(pointer > PIN.length()){break;}
		}
		//System.out.println(pointer);
		if(pointer != PIN.length()){
			System.out.println("non sequitur");
		}
		else{
			int number = Integer.parseInt(numberString);
			System.out.println(compressNumber(number));
		}
	}

	static int compressNumber(int num){
		String numString = String.valueOf(num);
		int total = 0;
		for(char n : numString.toCharArray()){
			total += Integer.parseInt(String.valueOf(n));
		}
		return total;
	}
}
