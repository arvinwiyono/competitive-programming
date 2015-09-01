import java.util.*;
public class FTalkingMoney{
	public static final String [] normalNumbers = {
		"zero","one","two","three","four","five","six",
		"seven","eight","nine","ten","eleven","twelve",
		"thirteen","fourteen","fifteen","sixteen","seventeen",
		"eighteen","nineteen"
	};

	public static final String [] tens = {
		"twenty","thirty","forty","fifty",
		"sixty","seventy","eighty","ninety"
	};

	public static final String [] units = {
		"hundred", "thousand", "million", "billion"
	};
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		Money m = new Money(sc.nextLine());
		System.out.println(m.getTextRepresentation());

	}

	//testing
	public static void testHundred(){
		Money m = new Money();
		for(int i = 0; i < 1000; i++){
			String s = String.format("%3s", String.valueOf(i)).replace(' ', '0');
			System.out.println(m.getHundred(s));
		}
	}

	//testing
	public static void testTen(){
		Money m = new Money();
		System.out.println(m.getTen("19"));
		for(int i = 20; i < 100; i++){
			System.out.println(m.getTen(String.valueOf(i)));
		}
	}
	static class Money{
		String money;
		String textRep;

		public Money(){}

		public Money(String s){
			this.money = s;
			textRep = convertToText();
		}
		public String getTextRepresentation(){
			return textRep;
		}

		public String convertToText(){
			String [] dollarAndCents = getDollarCents();
			String dollarString = dollarAndCents[0], centString = dollarAndCents[1];
			boolean isCredit = getCreditOrDebit();
			
			String output = "";
			long value = Long.parseLong(dollarString);
			int centValue = Integer.parseInt(centString);
			
			if (value == 0 && centValue == 0) {
				return "zero dollars and zero cents";
			}
			
			//Still need debit or credit
			if(value == 1){
				output += "one dollar";
				output += " and " + getCent(centString);
			}
			else if(value == 0){
				output += "zero dollars";
				output += " and " + getCent(centString);
			}

			else{
				String [] dollarPartition = partitionDollar(dollarString);

				String [] hundreds = new String[dollarPartition.length];		
				for(int i = 0; i < dollarPartition.length; i++){
					hundreds[i] = getHundred(dollarPartition[i]);
				}
				
				int unitPointer = dollarPartition.length;
				for(int i = 0; i < hundreds.length; i++){
					unitPointer--;
					if(hundreds[i].isEmpty()){continue;}
					else{
						if(i == 0){
							output += hundreds[i];
						}
						else{
							if(( Integer.parseInt(dollarPartition[i]) < 100 ) && (i == hundreds.length -1)){
								output += " and " + hundreds[i];
							}
							else{
								output += " " + hundreds[i];
							}
						}
						if(i != hundreds.length-1){
							output += " " + units[unitPointer];
						}
					}
				}
				output += " dollars and " + getCent(centString);
			}

			if(isCredit){
				output += " in credit";
			}
			else{
				output += " in debit";
			}

			return output.trim();
		}

		public String getCent(String numString){
			int value = Integer.parseInt(numString);
			String result = getTen(numString);
			if(value == 1){
				result += " cent";
			}
			else{
				result += " cents";
			}
			return result;
		}

		public String getHundred(String numString){

			String tens = getTen(numString.substring(1,3));
			if(tens.equals("zero")){tens = "";}

			int firstDigit = Integer.parseInt(numString.substring(0,1));
			if(firstDigit == 0){
				return tens;
			}
			else{
				if(tens.equals("")){
					return normalNumbers[firstDigit] + " " + units[0];
				}
				else{
					return normalNumbers[firstDigit] + " " + units[0] + " and " + tens; 
				}
			}
		}

		public String getTen(String numString){
			int value = Integer.parseInt(numString);
			if(value < 20){
				return normalNumbers[value];
			}
			else{
				int firstDigit = Integer.parseInt(numString.substring(0,1));
				int secondDigit = Integer.parseInt(numString.substring(1,2));
				if(secondDigit > 0){
					return tens[firstDigit-2] + "-" + normalNumbers[secondDigit];
				}
				else{
					return tens[firstDigit-2];
				}
			}
		}

		// tested
		private String [] partitionDollar(String dollar){
			int n = (int) Math.ceil((double)dollar.length()/3);
			char [][] array = new char[n][3];
			for(char [] a : array){Arrays.fill(a, '0');}

			int pointerBackward = dollar.length()-1;
			for(int i = n-1; i >-1; i--){
				for(int j = 2; j > -1; j--){
					try{
						array[i][j] = dollar.charAt(pointerBackward);
						pointerBackward--;
					}catch(Exception e){}
				}
			}

			//Convert all partitions to string
			String [] output = new String[n];
			int counter = 0;
			for(char [] a : array){
				String returnString = "";
				for(char c : a){
					returnString += c;
				}
				output[counter] = returnString;
				counter++;
			}
			return output;
		}

		// tested
		private boolean getCreditOrDebit(){
			if(money.charAt(0) == '-'){
				return false;
			}
			else{
				return true;
			}
		}

		//tested
		private String [] getDollarCents(){
			int dollarPointer = 0, centPointer = 0;
			for(int i = 0; i < money.length(); i++){
				if(money.charAt(i) == '$'){
					dollarPointer = i + 1;
				}
				else if(money.charAt(i) == '.'){
					centPointer = i + 1;
					break;
				}
			}
			String [] array = new String [2];
			array[0] = money.substring(dollarPointer, centPointer-1);
			array[1] = money.substring(centPointer, money.length());
			return array;
		}
	}
}