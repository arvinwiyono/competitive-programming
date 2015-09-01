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
					int lengthA = wordA.length(), lengthB = wordB.length();
					int maxLength = Math.max(lengthA, lengthB);
					//Make them have the same length by padding them with space
					for(int i = lengthA; i < maxLength; i++){
						wordA = " " + wordA;
					}
					for(int i = lengthB; i < maxLength; i++){
						wordB = " " + wordB;
					}

					//Update char arrays
					charA = wordA.toCharArray(); charB = wordB.toCharArray();
					HashMap <Character, Integer> hmA = makeHash(charA);
					HashMap <Character, Integer> hmB = makeHash(charB);
					
					int charDiffCounter = 0, diff1 = 0, diff2 = 0;
					Integer totalA = 0, totalB = 0;
					
					for(char c : hmA.keySet()){
						totalA = hmA.get(c);
						totalB = hmB.get(c);
						if(totalB == null){totalB = 0;}
						diff1 += Math.abs(totalA - totalB);
					}
					
					for(char c : hmB.keySet()){
						totalB = hmB.get(c);
						totalA = hmA.get(c);
						if(totalA == null){totalA = 0;}
						diff2 += Math.abs(totalA - totalB);
					}
					
					charDiffCounter = Math.min(diff1, diff2);
					
					wordA = wordA.trim(); wordB = wordB.trim();
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