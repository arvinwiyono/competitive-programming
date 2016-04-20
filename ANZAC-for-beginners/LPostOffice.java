import java.util.*;
public class LPostOffice{
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()){
			double [] numbers = new double [3];
			for(int i = 0; i < 3; i++){
				numbers[i] = sc.nextDouble(); 
			}

			Arrays.sort(numbers);

			double l, h, t;
			l = numbers[2]; h = numbers[1]; t = numbers[0];

			if(l+h+t == 0){break;}

			// System.out.println(l + " " + h + " " + t);
			if(isLetter(l,h,t)){
				System.out.println("letter");
			}
			else if(isPacket(l,h,t)){
				System.out.println("packet");
			}
			else if(isParcel(l,h,t)){
				System.out.println("parcel");
			}
			else{
				System.out.println("not mailable");
			}
		}

	}

	static boolean isLetter(double l, double h, double t){
		
		if( l >= 125 && l <= 290 ){
			if( h >= 90 && h <= 155 ){
				if( t >= 0.25 && t <= 7 ){
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean isPacket(double l, double h, double t){
		boolean exceedOne = false;
		if(l > 290 || h > 155 || t > 7){
			exceedOne = true;
		}

		boolean greater = false;
		if(l >= 125 && h >= 90 && t >= 0.25){
			greater = true;
		}

		if(exceedOne && greater){
			if(l <= 380 && h <= 300 && t <= 50){
				return true;
			}
		}

		return false;
	}

	static boolean isParcel(double l, double h, double t){
		boolean exceedOne = false;
		if(l > 380 || h > 300 || t > 50){
			exceedOne = true;
		}

		boolean greater = false;
		if(l >= 125 && h >= 90 && t >= 0.25){
			greater = true;
		}

		if(exceedOne && greater){
			if( (l + (2*(h+t))) <= 2100 ){
				return true;
			}
		}
		return false;
	}
}