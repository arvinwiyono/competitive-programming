import java.util.*;
public class GComplexity{
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);

		HashMap <Character, Integer> map = new HashMap <Character, Integer>();

		String input = sc.next();
		char [] characters = input.toCharArray();


		//calculate distinct letters
		for(char c : characters){
			if(!map.containsKey(c)){
				map.put(c, 1);
			}
			else{
				map.put(c, map.get(c)+1);
			}
		}

		List<Letter> list = new ArrayList<Letter>();

		for(char c : map.keySet()){
			list.add(new Letter(c, map.get(c)));
		}

		Collections.sort(list);


		// debugging
		// for(Letter l : list){
		// 	System.out.println(l.c + " --> " + l.occurance);
		// }

		if(list.size() <= 2){
			System.out.println(0);
		}
		else{
			int total = 0;
			for(int i = 0; i < list.size()-2; i++){
				total += list.get(i).occurance;
			}
			System.out.println(total);
		}
	}

	static class Letter implements Comparable<Letter>{
		char c;
		int occurance;
		public Letter(char ch, int o){
			c = ch;
			occurance = o;
		}

		public int compareTo(Letter other){
			return this.occurance - other.occurance;
		}
	}
}