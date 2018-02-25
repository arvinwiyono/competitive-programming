import java.util.*;
public class uva459GraphConnectivity {
	public static class Node{
		ArrayList <Character> connectedTo;
		boolean visited;
		public Node(){
			connectedTo = new ArrayList<Character>();
			visited = false;
		}
	}
	
	public static void main(String []  args){
		Scanner sc = new Scanner(System.in);
		int numTest = sc.nextInt(); sc.nextLine();
		sc.nextLine();
		
		while(numTest > 0){

			char biggest = sc.nextLine().trim().charAt(0);
			HashMap <Character, Node> map = new HashMap <Character, Node>();
			for(char i = 65; i <= biggest; i++){
				map.put((Character) i, new Node());
			}
			
			String input = sc.nextLine().trim();
			while(!input.equals("")){
				char [] connectedNodes = input.toCharArray();
				char from = connectedNodes [0];
				char to = connectedNodes[1];
				map.get(from).connectedTo.add(to);
				map.get(to).connectedTo.add(from);
				if(sc.hasNextLine()){
					input = sc.nextLine().trim();
				}
				else{
					input = "";
				}
			}
			
			System.out.println(depthFirstSearch(map));
			if(numTest > 1){
				System.out.println();
			}
			numTest--;
		}
	}
	
	public static int depthFirstSearch(HashMap <Character, Node> map){
		int counter = 0;
		for(Character c : map.keySet()){
			if(map.get(c).visited == false){
				dfs(map, map.get(c));
				counter ++;
			}
		}
		return counter;
	}
	
	public static void dfs (HashMap <Character, Node> map, Node n){
		n.visited = true;
		for(Character adjNode : n.connectedTo){
			if(map.get(adjNode).visited == false){
				//System.out.println("Visiting node " + adjNode);
				dfs(map, map.get(adjNode));
			}
		}
	}
	
}

