import java.util.*;
public class DPaintingFloors{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), n = sc.nextInt(); sc.nextLine();

		char [][] map = new char [m][n];
		for(int i = 0; i < m; i++){
			map[i] = sc.nextLine().toCharArray();
		}

		bfs(map, m, n);
	}

	static void bfs(char [][] map, int m, int n){
		Queue <Node> Q = new LinkedList <Node>();
		int [] offsetX = {1, 1, 0, -1, -1, -1, 0, 1};
		int [] offsetY = {0, 1, 1, 1, 0, -1, -1, -1};
		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[0].length; j++){

				if(map[i][j] == '.'){
					Q.offer(new Node(i, j));
				}

				while(!Q.isEmpty()){
				
					Node current = Q.poll();
					int cr = current.row, cc = current.col;
				
					if(map[cr][cc] == '.'){
				
						System.out.println((cr+1) + " " + (cc+1));
						//colour the row
						for(int k = cc; k > -1; k--){
							if(map[cr][k] =='x'){break;}
							else{map[cr][k] = 'o';}
						}
						for(int k = cc; k < n; k++){
							if(map[cr][k] =='x'){break;}
							else{map[cr][k] = 'o';}
						}

						//colour the column
						for(int k = cr; k > -1; k--){
							if(map[k][cc] =='x'){break;}
							else{map[k][cc] = 'o';}
						}
						for(int k = cr; k < m; k++){
							if(map[k][cc] =='x'){break;}
							else{map[k][cc] = 'o';}
						}

						for(int k = 0; k < offsetX.length; k++){
							try{
								if(map[cr + offsetX[k]][cc + offsetY[k]] == '.'){
									Q.offer(new Node(cr + offsetX[k], cc + offsetY[k]));
								}
							}
							catch(Exception e){}
						}
						//debug
						// for(int k = 0; k < map.length; k++){
						// 	System.out.println(Arrays.toString(map[k]));
						// }
					}
				}
			}
		}
	}

	static class Node{
		int row, col;
		public Node(int r, int c){
			row = r;
			col = c;
		}
	}
}