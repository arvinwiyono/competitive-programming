import java.util.*;

public class KToweringProblem{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		Integer [] heights = new Integer [6];
		for(int i = 0; i < 6; i++){
			heights[i] = sc.nextInt();
		}

		int target1 = sc.nextInt();
		int target2 = sc.nextInt();

		List<Integer> firstTower = new ArrayList<Integer>();

		boolean firstDiscovered = false;
		boolean secondDiscovered = false;

		for(int i = 0; i < heights.length - 2; i++){
			for(int j = i + 1; j < heights.length - 1; j++){
				for(int k = i + 2; k < heights.length; k++){
					firstTower = new ArrayList<Integer>();

					firstTower.add(heights[i]);
					firstTower.add(heights[j]);
					firstTower.add(heights[k]);
					int sum = getSum(firstTower);
					if(sum == target1 || sum == target2){
						if(sum == target1){firstDiscovered = true;}
						else if(sum == target2){secondDiscovered = true;}
						break;
					}
				}
				if(firstDiscovered || secondDiscovered){break;}
			}
			if(firstDiscovered || secondDiscovered){break;}	
		}

		List <Integer> secondTower = new ArrayList <Integer>(Arrays.asList(heights));

		for(int i : firstTower){
			secondTower.remove((Integer)i);
		}	

		Collections.sort(firstTower);
		Collections.sort(secondTower);

		// System.out.println(firstTower);
		// System.out.println(secondTower);

		int sum = getSum(firstTower);
		String output = "";
		if(sum == target1){
			for(int i = firstTower.size()-1; i >= 0; i--){
				output += firstTower.get(i) + " ";
			}
			for(int i = secondTower.size()-1; i >= 0; i--){
				output += secondTower.get(i) + " ";
			}
		}
		else{
			for(int i = secondTower.size()-1; i >= 0; i--){
				output += secondTower.get(i) + " ";
			}
			for(int i = firstTower.size()-1; i >= 0; i--){
				output += firstTower.get(i) + " ";
			}
		}

		System.out.println(output.substring(0, output.length()-1));
	}
 
	static int getSum(List<Integer> numbers){
		int total = 0;
		for(int i : numbers){
			total += i;
		}
		return total;
	}
}