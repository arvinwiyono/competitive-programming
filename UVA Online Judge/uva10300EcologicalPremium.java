import java.util.*;

public class uva10300EcologicalPremium{
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);
		int nTest = sc.nextInt();

		while (nTest > 0){
			int numFarmers = sc.nextInt();

			int total = 0;
			for(int i = 0; i < numFarmers; i++){
				int area, numAnimals, ecoPoint;
				area = sc.nextInt(); numAnimals = sc.nextInt(); ecoPoint = sc.nextInt();

				total += area * ecoPoint;
			}
			System.out.println(total);
			nTest --;
		}

	}
}