import java.util.*;
public class HBanking{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		String PIN = sc.nextLine().trim();
		String pattern = sc.nextLine().trim();
		String numberString = "0";
		
		int pointer = 0;
		for(char c : pattern.toCharArray()){
			
			if(c == Character.toLowerCase(c)){
				
				int temp = pointer + (int) c - 96;

				if(temp > PIN.length()){pointer = temp; break;}

				String sub = PIN.substring(pointer, temp);
				numberString += sub;
			}
			pointer += (int)Character.toUpperCase(c) - 64;
			if(pointer > PIN.length()){break;}
		}

		if(pointer != PIN.length()){
			System.out.println("non sequitur");
		}
		else{
			System.out.println(compressNumber(numberString));
		}
	}

	static int compressNumber(String num){
		int total = 0;
		for(char n : num.toCharArray()){
			total += Integer.parseInt(String.valueOf(n));
		}
		return total;
	}
}
