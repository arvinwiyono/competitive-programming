import java.util.*;

public class uva10226HardwoodSpecies {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int nTest = sc.nextInt(); sc.nextLine();
		//Get rid of new line after test case
		sc.nextLine();
		
		for(int testNo = 0; testNo < nTest; testNo++){
			
			HashMap <String, Integer> trees = new HashMap<String, Integer>();
			String input;
			int numTrees = 0;
			while(sc.hasNextLine()){
				input = sc.nextLine();
				if(input.isEmpty()){break;}
				numTrees++;
				if(trees.get(input) == null){
					trees.put(input, 1);
				}
				else{
					int total = trees.get(input);
					trees.put(input, total+1);
				}
			}
			
			Set keys = trees.keySet();
			String [] array = new String [keys.size()];
			keys.toArray(array);
			Arrays.sort(array);
			
			for(String treeName: array){
				System.out.printf("%s %.4f\n", treeName, ((double)trees.get(treeName)/numTrees * 100));
			}
			if(testNo != nTest-1){
				System.out.println();
			}
			else{
				break;
			}
		}
	}
}
