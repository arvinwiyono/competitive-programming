import java.util.*;

public class uva102EcologicalBinPacking{
	public static void main(String [] args){
		char [] characters = {'B', 'G', 'C'};
		int [][] permutations = {
			{0, 1, 2},
			{1, 0, 2},
			{1, 2, 0},
			{2, 1, 0},
			{2, 0, 1},
			{0, 2, 1}
		};

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){

			int [][] bins = new int [3][3];
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					bins[i][j] = sc.nextInt();
				}
			}
			PriorityQueue <QueueItem> pq = new PriorityQueue<QueueItem>();
			//for each permutation
			for(int [] p : permutations){
				int movement = 0;
				for(int i = 0; i < p.length; i++){
					for(int j = 0; j < bins.length; j++){
						if(i != j){
							movement += bins[j][p[i]];
						}
					}
				}
				String a = "";
				for(int i : p){
					a += characters[i];
				}
				pq.offer(new QueueItem(a, movement));
			}

			QueueItem result = pq.poll();
			System.out.println(result.arrangement + " " + result.movement );
		}
	}

	static class QueueItem implements Comparable<QueueItem>{
			String arrangement;
			int movement;
			public QueueItem(String a, int m){
				arrangement = a;
				movement = m;
			}

			public int compareTo(QueueItem others){
				if(this.movement == others.movement){
					return arrangement.compareTo(others.arrangement);
				}
				else{
					return this.movement - others.movement;
				}
			}
		}
}