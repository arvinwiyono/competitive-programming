import java.util.*;
public class uva1195ICanGuess {
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			
			Stack <Integer> s = new Stack <Integer>();
			List <Integer> sResult = new ArrayList<Integer>();
			
			PriorityQueue <Integer> pq = new PriorityQueue <Integer>(n + 100, new PriorityComparator());
			List <Integer> pqResult = new ArrayList<Integer>();
			
			Queue <Integer> q = new LinkedList <Integer>();
			List <Integer> qResult = new ArrayList<Integer>();
			
			List <Integer> inputResult = new ArrayList<Integer>();
			boolean error = false;
			for(int i = 0; i < n; i++){
				int command = sc.nextInt(); int num = sc.nextInt();
				if(command == 1){
					s.add(num); pq.add(num); q.offer(num);
				}
				else{
					error = false;
					try{
						sResult.add(s.pop()); pqResult.add(pq.poll()); qResult.add(q.poll());
						inputResult.add(num);
					}catch (Exception e){
						error = true;
					}
				}
			}
			
			if(!error){
				int counter = 0;
				boolean sameStack = false, samePriority = false, sameQueue = false;
				if(inputResult.equals(sResult)){sameStack = true; counter++;}
				if(inputResult.equals(pqResult)){samePriority = true; counter++;}
				if(inputResult.equals(qResult)){sameQueue = true; counter++;}
				
				if(counter == 1){
					if(sameStack){System.out.println("stack");}
					else if (sameQueue){System.out.println("queue");}
					else {System.out.println("priority queue");}
				}
				else if (counter > 1){
					System.out.println("not sure");
				}
				else if (counter == 0){
					System.out.println("impossible");
				}
			}
			else{
				System.out.println("impossible");
			}
				
		}
	}
}

class PriorityComparator implements Comparator<Integer>{
	public int compare(Integer i1, Integer i2){
		return i2 - i1;
	}
}