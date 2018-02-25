import java.util.*;
public class uva10954AddAll {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		while (N != 0){
			PriorityQueue <Integer> pq = new PriorityQueue<Integer>();
			for(int i = 0; i < N; i++){
				pq.offer(sc.nextInt());
			}
			List <Integer> allCost = new ArrayList<Integer>();
			int cost = 0;
			while(true){
				int num1 = pq.poll();
				int num2 = pq.poll();
				cost = num1+num2;
				//System.out.println("Cost = " + cost);
				allCost.add(cost);
				if(pq.isEmpty()){
					break;
				}
				else{
					pq.offer(cost);
				}
			}
			int result = 0;
			for(Integer i : allCost){
				result += i;
			}
			
			System.out.println(result);
			N = sc.nextInt();
		}
		
	}
}
