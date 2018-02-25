import java.util.*;
public class uva10004Bicolour {
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n == 0){break;}
			int l = sc.nextInt();	
			
			int [][] adjMatrix = new int [n][n];
			for(int i = 0 ; i < l ; i++){
				int from = sc.nextInt();
				int to = sc.nextInt();
				adjMatrix[from][to] = 1;
				adjMatrix[to][from] = 1;
			}
//			for(int [] a : adjMatrix){
//				System.out.println(Arrays.toString(a));
//			}
			
			Node [] nodes = new Node [n];
			for(int i = 0 ; i < nodes.length; i++){
				nodes[i] = new Node(i);
			}
			
			boolean result = bfs(adjMatrix, nodes);
			if(result){
				System.out.println("BICOLORABLE.");
			}
			else{
				System.out.println("NOT BICOLORABLE.");
			}
		}
	}
	
	public static boolean bfs(int [][] matrix, Node [] nodes){
		int [] colourArray = {0,1};
		Queue <Node> q = new LinkedList<Node>();
		nodes[0].color = 0;
		q.offer(nodes[0]);
		boolean isBicoloured = true;
		while(!q.isEmpty()){
			Node current = q.poll();
			//for each adjacent node
			for(int i = 0; i < matrix[current.number].length; i++){
				//If there is connection
				if(matrix[current.number][i] == 1){
					if(nodes[i].color == -1){
						nodes[i].color = colourArray[1 - current.color];
						q.offer(nodes[i]);
					}
					else{
						if(nodes[i].color == current.color){
							isBicoloured = false;
							break;
						}
					}
				}
			}
		}
		return isBicoloured;
	}
	
	static class Node{
		
		//-1 means not coloured yet
		int color;
		int number;
		public Node(int num){
			color = -1;
			number = num;
		}
	}
}
