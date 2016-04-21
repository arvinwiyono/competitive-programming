import java.util.*;
public class ITriangleGame{
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);

		List <Triangle> triangles = new ArrayList <Triangle> ();
		for(int i = 0 ; i < 6; i ++){
			triangles.add(new Triangle(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		// this is where we collect the points/results
		List <Integer> hexagons = new ArrayList <Integer> ();

		Triangle start = triangles.get(0);

		// first triangle has 3 sides
		for(int i = 0; i < 3; i ++){
		
			List <Triangle> partialSolution = new ArrayList <Triangle> ();
			partialSolution.add(start);		
		
			List <Triangle> options = new ArrayList <Triangle> ();
			for(Triangle t : triangles){
				options.add((Triangle) t.clone());
			}

			options.remove(0);

			List <Integer> discoveredHexagons = new ArrayList <Integer>();

			List <Integer> result = backtrack(partialSolution, options, discoveredHexagons, options.size());

			for(int number : result){
				hexagons.add(number);
			}

			start.rotate();
		}
		if(hexagons.size()>0){
			Collections.sort(hexagons);
			System.out.println(hexagons.get(hexagons.size()-1));
		}
		else{
			System.out.println("none");
		}
	}

	public static List<Integer> backtrack(List <Triangle> partial, List<Triangle> options, List<Integer> resultsHolder, int threshold){
		
		// System.out.println("--- BACKTRACK --- " + threshold);

		if(partial.size() == 6){
			// System.out.println("FOUND IT!");

			Triangle last = partial.get(partial.size()-1);
			Triangle first = partial.get(0);
			if(last.getRightMost() == first.getLeftMost()){
				int temp = 0;
				for(Triangle t : partial){
					temp += t.getPoint();
				}
				Integer point = new Integer(temp);
				// System.out.println(point);
				resultsHolder.add(point);
			}
			return resultsHolder;
		}
		else{	
			// value -1 is chosen for validity checking
			Triangle next = new Triangle (-1,-1,-1);
			Triangle current = partial.get(partial.size()-1);
			// try to find one matching triangle
			for(int j = 0; j < threshold; j++){
				Triangle t = options.get(j);
				if(t.rotateAndMatch(current.getRightMost())){
					next = t;
					break;
				}
			}

			// if you can find one matching triangle
			if(next.getPoint() != -1){
				int loop = options.size();
				for(int i = 0; i < loop; i++){
					partial.add(next);
					options.remove((Triangle)next);
					// need to reduce threshold to limit options. Otherwise same soltuions will come up again
					resultsHolder = backtrack(partial, options, resultsHolder, options.size()-i);
					Triangle temp = partial.get(partial.size()-1);
					partial.remove(temp);
					options.add(temp);
				}
			}
			return resultsHolder;
		}
	}

	static class Triangle{
		
		int p1, p2, p3;
		public Triangle(int point1, int point2, int point3){
			p1 = point1;
			p2 = point2;
			p3 = point3;
		}

		public boolean rotateAndMatch(int target){
			// there must be a parameter to stop the loop
			int loop = 0;
			while( (getLeftMost() != target) && loop < 3 ){
				rotate();
				loop++;
			}
			if(getLeftMost() == target){
				return true;
			}
			return false;
		}

		public void rotate(){
			int temp = p3;
			p3 = p2;
			p2 = p1;
			p1 = temp;
		}

		public Triangle clone(){
			return new Triangle(p1,p2,p3);
		}

		public int getLeftMost(){
			return p1;
		}

		public int getRightMost(){
			return p2;
		}

		public int getPoint(){
			return p3;
		}
		// for debugging purpose
		public String getInfo(){
			return p1 + " " + p2 + " " + p3;
		}
	}
}
