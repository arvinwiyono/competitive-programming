import java.util.*;
public class uva469WetlandsOfFlorida {
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int nTest = sc.nextInt(); sc.nextLine();
		//Get rid of new line after the number of test cases
		sc.nextLine();
		
		for(int test = 0; test < nTest; test++){
			Map map = new Map();
			//Get map
			while(sc.hasNextLine()){
				if(sc.hasNextInt()){break;}
				String input = sc.nextLine();
				map.addArray(input.toCharArray());
			}
			
			while(sc.hasNextLine()){
				String query = sc.nextLine();
				if(query.length() == 0){break;}
				String [] numbers = query.split(" ");
				int i = Integer.parseInt(numbers[0]), j = Integer.parseInt(numbers[1]);
				int result = bfs(map, i-1, j-1);
				System.out.println(result);
			}
			if(test != nTest-1){
				System.out.println("");
			}
		}
		
	}
	public static int bfs(Map m, int i, int j){
		int [] xOffset = {1, 1, 0, -1, -1, -1, 0, 1};
		int [] yOffset = {0, 1, 1, 1, 0, -1, -1, -1};
		
		Queue <Node> q = new LinkedList<Node>();
		char [][] map = m.getArray();
		int answer = 0;
		if(map[i][j] == 'W'){
			answer++;
			map[i][j] = '*';
		}
		q.add(new Node(i, j));
		while(!q.isEmpty()){
			Node current = q.poll();
			for(int k = 0; k < xOffset.length; k++){
				try{
					int row = current.r + yOffset[k], col = current.c + xOffset[k];
					char mark = map[row][col];
					if(mark == 'W'){
						answer++;
						map[row][col] = '*';
						q.add(new Node(row , col));
					}
				}catch(Exception e){continue;}
			}
		}
		return answer;
	}
	
	static class Node{
		int r, c;
		public Node(int row, int col){
			r = row; c = col;
		}
	}
	static class Map{
		List<char []> list;
		public Map(){
			list = new ArrayList<char []> ();
		}
		public void addArray(char [] a){
			list.add(a);
		}
		public void print(){
			for(char [] a : list){
				System.out.println(Arrays.toString(a));
			}
		}
		public char [][] getArray(){
			List <char[]> copy = new ArrayList<char[]>();
			for(char [] a : list){
				copy.add(a.clone());
			}
			char [][] output = new char[copy.size()][copy.get(0).length];
			copy.toArray(output);
			return output;
		}
	}
}

