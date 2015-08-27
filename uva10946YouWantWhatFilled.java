import java.util.*;
public class uva10946YouWantWhatFilled{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int counter = 0;
		while(true){
			counter++;
			int x = sc.nextInt(), y = sc.nextInt(); sc.nextLine();
			if(x + y == 0){break;}

			char [][] map = new char [x][y];
			for(int i = 0; i < x; i ++){
				map[i] = sc.nextLine().toCharArray();
			}

			// for(char [] a : map){
			// 	System.out.println(Arrays.toString(a));
			// }
			
			bfs(map, counter);
		}
	}

	static void bfs(char [][] map, int counter){
		int [] offsetX = {-1, 0, 0, 1};
		int [] offsetY = {0, 1, -1, 0};
		
		Queue <Node> q = new LinkedList <Node> ();
		List <HoleGroup> holes = new ArrayList<HoleGroup>();

		for(int i = 0; i < map.length; i++){
			for(int j = 0; j < map[i].length; j++){
				
				char mainChar = '.';
				HoleGroup hole = new HoleGroup();
				while(mainChar =='.'){
					if(map[i][j] != '.'){
						mainChar = map[i][j];
						hole = new HoleGroup(mainChar);
						holes.add(hole);
						map[i][j] = '.';
						q.offer(new Node(i, j));
					}
					else{break;}
				}

				while(!q.isEmpty()){
					Node current = q.poll();
					for(int k = 0; k < offsetX.length; k++){
						try{
							int currentRow = current.row+offsetX[k], currentCol = current.col+offsetY[k];
							char c = map[currentRow][currentCol];
							if(c == mainChar){
								hole.num++;
								map[currentRow][currentCol] = '.';
								q.offer(new Node(currentRow, currentCol));
							}
						}catch(Exception e){}
					}
				}
			}
		}

		//sort the collections
		Collections.sort(holes, new HoleComparator());
		
		//System.out.println(list);
		System.out.println("Problem " + counter + ":");
		for(HoleGroup h : holes){
			System.out.println(h.getInfo());
		}
	}

	static class HoleComparator implements Comparator<HoleGroup>{
		public int compare(HoleGroup h1, HoleGroup h2){
			if(h1.num == h2.num){
				return h1.symbol - h2.symbol;
			}
			else{
				return h2.num - h1.num;
			}
		}
	}
	static class Node{
		int row, col;
		public Node(int r, int c){
			row = r; col = c;
		}
	}
	static class HoleGroup{
		int num;
		char symbol;
		public HoleGroup(){};
		public HoleGroup(char s){
			symbol = s;
			num = 1;
		}
		public String getInfo(){
			return symbol + " " + num;
		}
	}
}