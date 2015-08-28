import java.util.*;

public class JAnagram{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		String wordA = sc.next(), wordB = sc.next();
		
		if(wordA.equals(wordB)){
			printFormat(wordA, wordB, " is identical to ");
		}
		else{
			char [] charA = wordA.toCharArray();
			Arrays.sort(charA);

			char [] charB = wordB.toCharArray();
			Arrays.sort(charB);
			
			if(Arrays.equals(charA, charB)){
				printFormat(wordA, wordB, " is an anagram of ");
			}
			else{
				int lengthDiff = Math.abs(wordA.length() - wordB.length());
				if(lengthDiff > 1){
					printFormat(wordA, wordB, " is nothing like ");
				}
				else{
					HashMap <Character, Integer> hmA = makeHash(charA);
					HashMap <Character, Integer> hmB = makeHash(charB);
					
					int lengthA = wordA.length(), lengthB = wordB.length();
					int charDiffCounter = 0;
					Integer totalA = 0, totalB = 0;
					if(lengthA > lengthB){
						for(char c : hmA.keySet()){
							totalA = hmA.get(c);
							totalB = hmB.get(c);
							if(totalB == null){totalB = 0;}
							charDiffCounter += Math.abs(totalA - totalB);
						}
					}
					else{
						for(char c : hmB.keySet()){
							totalB = hmB.get(c);
							totalA = hmA.get(c);
							if(totalA == null){totalA = 0;}
							charDiffCounter += Math.abs(totalA - totalB);
						}
					}

					if(charDiffCounter > 1){
						printFormat(wordA, wordB, " is nothing like ");
					}
					else{
						printFormat(wordA, wordB, " is almost an anagram of ");
					}
				}
			}
		}
	}

	static HashMap <Character, Integer> makeHash(char [] array){
		HashMap <Character, Integer> hm = new HashMap <Character, Integer>();
		for(char c : array){
			if(hm.get(c) == null){
				hm.put(c, 1);
			}
			else{
				hm.put(c, hm.get(c)+1);
			}
		}
		return hm;
	}

	static void printFormat(String wa, String wb, String connector){
		if(wa.length() == wb.length()){
			String [] words = {wa, wb};
			Arrays.sort(words);
			System.out.println(words[0] + connector + words[1]); 
		}
		else if(wa.length() < wb.length()){
			System.out.println(wa + connector + wb); 
		}
		else if(wb.length() < wa.length()){
			System.out.println(wb + connector + wa);
		}

	}
}