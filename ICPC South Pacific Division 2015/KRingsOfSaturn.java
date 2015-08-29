import java.util.*;
public class KRingsOfSaturn{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt();
		
		IndividualSet set = new IndividualSet(n);
		for(int i = 0; i < m; i++){
			int ids = sc.nextInt(), idr = sc.nextInt(), t = sc.nextInt();
			set.union(ids, idr, t);
		}
		
		set.updateParent();
		
		HashMap <Integer, Integer> ringHM = new HashMap<Integer, Integer>();
		//Count the number of individuals for each set number
		for(Individual i : set.individuals){
			if(ringHM.get(i.pointTo) == null){
				ringHM.put(i.pointTo, 1);
			}
			else{
				ringHM.put(i.pointTo, ringHM.get(i.pointTo)+1);
			}
		}
		
		//Find set numbers which exactly contain 7 individuals
		List <Integer> validRings = new ArrayList<Integer>();
		for(Integer i : ringHM.keySet()){
			//System.out.println(i + " ==> " + ringHM.get(i));
			if(ringHM.get(i) == 7){
				validRings.add(i);
			}
		}

		List <Ring> rings = new ArrayList<Ring>();
		for(Integer i : validRings){
			Ring ring = new Ring();
			for(Individual individual : set.individuals){
				if(individual.pointTo == i){
					if(individual.num < ring.smallestNum){
						ring.smallestNum = individual.num;
					}
					if(individual.totalThreat > ring.biggestTotal){
						ring.biggestTotal = individual.totalThreat;
					}
				}
			}
			rings.add(ring);
		}

		Collections.sort(rings);
		if(rings.size() > 0){
			for(Ring r : rings){
				System.out.println(r.smallestNum + " " + r.biggestTotal);
			}
		}
		else{
			System.out.println("There is currently no threat to Earth");
		}
	}

	static class Ring implements Comparable<Ring>{
		int smallestNum = Integer.MAX_VALUE, biggestTotal = 0;
		public Ring(){}

		public int compareTo(Ring other){
			if(this.biggestTotal == other.biggestTotal){
				return this.smallestNum - other.smallestNum;
			}
			else{
				return other.biggestTotal - this.biggestTotal;
			}
		}
	}

	static class IndividualSet{
		Individual [] individuals;
		public IndividualSet(int n){
			individuals = new Individual [n];
			for(int i = 0; i < n; i++){
				individuals[i] = new Individual(i);
			}
		}
		//debugging
		public void printInfo(){
			for(Individual i : individuals){
				System.out.println(i.getInfo());
			}
			System.out.println();
		}

		public int findParent(int n){
			if(individuals[n].pointTo == n){
				return individuals[n].num;
			}
			else{
				individuals[n].pointTo = findParent(individuals[n].pointTo);
				return individuals[n].pointTo;
			}
		}

		public void union(int i1, int i2, int threat){
			Individual parent1 = individuals[findParent(i1)];
			Individual parent2 = individuals[findParent(i2)];
			if(parent1.num < parent2.num){
				parent2.pointTo = parent1.num;
				parent1.totalThreat += parent2.totalThreat + threat;
			}
			else if(parent2.num < parent1.num){
				parent1.pointTo = parent2.num;
				parent2.totalThreat += parent1.totalThreat + threat;
			}
			else if(parent1 == parent2){
				parent1.totalThreat += threat;
			}
		}

		public void updateParent(){
			for(int i = 0 ; i < individuals.length; i++){
				int result = findParent(i);
			}
		}
	}


	static class Individual{
		int pointTo, totalThreat, num;
		public Individual(int n){
			pointTo = n;
			num = n;
			totalThreat = 0;
		}
		public String getInfo(){
			return num+ " --> " + pointTo + ", threat: " + totalThreat; 
		}
	}
}