import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.HashMap;
public class uva1203Argus {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String keyword = sc.next();
		HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
		
		while(!keyword.equals("#")){
			int Qnum = sc.nextInt();
			int period = sc.nextInt();
			map.put(Qnum, period);
			keyword = sc.next();
		}
		int queries = sc.nextInt();
		int counter = 0;
		//Need to specify the size for Java 1.70
		PriorityQueue <Query> PQ = new PriorityQueue<Query>(map.size(), new QueryComparator());
		
		for(Integer key : map.keySet()){
			PQ.add(new Query(key, map.get(key)));
		}
		while (counter < queries){
			counter++;
			Query current = PQ.poll();
			PQ.add(new Query(current.num, current.period + map.get(current.num)));
			System.out.println(current.num);
		}
		sc.close();
	}
}

class QueryComparator implements Comparator<Query>{
	public int compare (Query q1, Query q2){
		if(q1.period == q2.period){
			return q1.num - q2.num;
		}
		else{
			return (int) (q1.period - q2.period);
		}
	}
}

class Query{
	int num;
	long period;
	public Query(int q, long l){
		num = q;
		period = l;
	}
}

