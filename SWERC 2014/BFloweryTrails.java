import java.util.*;

public class BFloweryTrails{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int P = sc.nextInt(), T = sc.nextInt();

		Vertex [] graph = new Vertex[P];
		for(int i = 0; i < graph.length; i++){
			graph[i] = new Vertex(i);
		}

		for(int i = 0; i < T; i++){
			int from = sc.nextInt(), to = sc.nextInt(), length = sc.nextInt();
			Edge e1 = new Edge(i, to, length);
			Edge e2 = new Edge(i+1, from, length);
			graph[from].connectTo(e1);
			graph[to].connectTo(e2);
		}

		dijkstra(graph, 0, P-1);
		int result = getFlowerTrail(graph, P-1);
		System.out.println(result*2);
	}

	static int getFlowerTrail(Vertex [] graph, int vertexId){
		if(vertexId == 0){
			return 0;
		}

		int total = 0;
		Vertex current = graph[vertexId];
		// System.out.println("Vertex ID: " + current.id);
		for(BackTrail bt : current.predecessor){
			if(!bt.discovered){
				//System.out.println(bt.getInfo());
				bt.discovered = true;
				total += bt.length;
			}
		}
		
		for(Integer i : current.commonSource){
			total += getFlowerTrail(graph, i);
		}
		return total;
	}

	static void dijkstra(Vertex[] graph, int from, int to){
		PriorityQueue <Node> pq = new PriorityQueue<Node>();
		graph[from].shortestDist = 0;
		pq.offer(new Node(from, graph[from].shortestDist));
		
		while(!pq.isEmpty()){

			Node currentNode = pq.poll();
			Vertex currentVertex = graph[currentNode.num];
			
			if(currentNode.distance > currentVertex.shortestDist){continue;}
	
			for(Edge e : currentVertex.edges){
				//System.out.println(e.getInfo());
				
				int destination = e.dest;
				int length = e.length;
				Vertex target = graph[destination];
	
				int newDistance = currentNode.distance + length;
				if(newDistance <= target.shortestDist){
					// System.out.println("YES target: " + target.id + " " + length);
				 	if(newDistance == target.shortestDist){
				 		target.predecessor.add(new BackTrail(e.id, currentVertex.id, e.length));				 							 		
				 	}
				 	else{
				 		target.predecessor.clear();
				 		target.predecessor.add(new BackTrail(e.id, currentVertex.id, e.length));
				 	}
				 	if(newDistance < target.shortestDist){
					 	target.shortestDist = newDistance;
					 	pq.offer(new Node(e.dest, target.shortestDist));
					}
				}
			
			}
		}

		for(Vertex v : graph){
			v.getCommonSources();
		}
	}

	static class Node implements Comparable<Node>{
		int num, distance;
		public Node(int n, int d){
			num = n;
			distance = d;
		}
		public int compareTo(Node other){
			return this.distance - other.distance;
		}

		public String getInfo(){
			return num + " " + distance;
		}
	}

	static class Vertex{
		int id;
		List <Edge> edges;
		List <BackTrail> predecessor;
		List <Integer> commonSource;
		int shortestDist;

		public Vertex(int n){
			id = n;
			edges = new ArrayList<Edge>();
			predecessor = new ArrayList<BackTrail>();
			commonSource = new ArrayList<Integer>();
			shortestDist = Integer.MAX_VALUE;
		}

		public void connectTo(Edge e){
			edges.add(e);
		}
		public void printInfo(){
			System.out.println("Vertex " + id);
			for(Edge e : edges){
				System.out.println(e.getInfo());
			}
		}

		public void printPredecessor(){
			System.out.println("Vertex " + id);
			for(BackTrail bt : predecessor){
				System.out.println(bt.getInfo());
			}
		}

		private void getCommonSources(){
			commonSource.clear();
			for(BackTrail bt : predecessor){
				if(commonSource.indexOf(bt.dest) == -1){
					commonSource.add(bt.dest);
				}
			}
		}
	}

	static class Edge{
		int id, dest, length;
		
		public Edge(int i, int d, int l){
			id = i;
			dest = d;
			length = l;
		}

		public String getInfo(){
			return "==> " + dest + ", " + length;
		}
	}

	static class BackTrail extends Edge{
		boolean discovered;
		public BackTrail(int i, int d, int l){
			super(i, d, l);
			discovered = false;
		}

		@Override
		public String getInfo(){
			return dest + " <== , " + length + " " + discovered ;
		}
	}
}

// TEST DATA
// 10 15
// 0 1 580
// 1 4 90
// 1 4 90
// 4 9 250
// 4 2 510
// 2 7 600
// 7 3 200
// 3 3 380
// 3 0 150
// 0 3 100
// 7 8 500
// 7 9 620
// 9 6 510
// 6 5 145
// 5 9 160

// 4 7
// 0 1 1
// 0 2 2
// 0 3 10
// 0 3 3
// 1 3 2
// 2 3 1
// 1 1 1