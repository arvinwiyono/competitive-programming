import java.util.*;
public class BBottledUp{
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);

		int totalOil = sc.nextInt();
		int largeVolume = sc.nextInt();
		int smallVolume = sc.nextInt();


		int maxLarge = totalOil/largeVolume;

		boolean achieved = false;
		
		for(int i = maxLarge; i >= 0; i--){
			int temp = totalOil;
			temp -= i * largeVolume;
			
			if ( temp % smallVolume == 0){
				int numSmall = temp / smallVolume;
				System.out.println(i + " " + numSmall);
				achieved = true;
				break;
			}
		}
		if(!achieved){
			System.out.println("Impossible");
		}
	}
}