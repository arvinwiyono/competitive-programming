import java.util.*;

public class HVowels{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		HashMap <Character, Integer> map = new HashMap <Character, Integer>();

		map.put('a', 0);
		map.put('i', 0);
		map.put('u', 0);
		map.put('e', 0);
		map.put('o', 0);

		char [] characters = sc.nextLine().toCharArray();

		for(char c : characters){
			char lowered = Character.toLowerCase(c);
			if(map.containsKey(lowered)){
				map.put(lowered, map.get(lowered)+1);
			}
		}

		ArrayList <Letter> list = new ArrayList <Letter>();

		for(char c : map.keySet()){
			list.add(new Letter(c, map.get(c)));
		}

		Collections.sort(list);

		String output = "";
		for(Letter l : list){
			output += l.c + ":" + l.occurance + " ";
		}

		System.out.println(output.substring(0, output.length()-1));
	}

	static class Letter implements Comparable<Letter>{
		char c;
		int occurance;
		public Letter(char ch, int o){
			c = ch;
			occurance = o;
		}

		public int compareTo(Letter other){
			if(this.occurance == other.occurance){
				return this.c - other.c;
			}
			else{
				return other.occurance - this.occurance;
			}
		}
	}
}