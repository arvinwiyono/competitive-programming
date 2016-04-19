import java.util.*;

public class MMagicTrick{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int nOperation = sc.nextInt();

		Calculation [] calculations = new Calculation [nOperation];

		for(int i = 0; i < nOperation; i++){
			calculations[i] = new Calculation(sc.next(), sc.nextInt());
		}

		int totalMessedUp = 0;
		for(int i = 1; i <= 100; i++){
			
			// System.out.println("Number: " + i);

			double temp = (double) i;

			for(Calculation c : calculations){
				if(c.operation.equals("ADD")){
					temp += c.operand;
				}
				else if(c.operation.equals("SUBTRACT")){
					temp -= c.operand;
				}
				else if(c.operation.equals("MULTIPLY")){
					temp *= c.operand;
				}
				else if(c.operation.equals("DIVIDE")){
					temp /= c.operand;
				}

				// System.out.println(temp);
				
				if(temp < 0 || !hasNoFraction(temp)){
					totalMessedUp++;
					break;
				}
			}

		}
			System.out.println(totalMessedUp);
	}	

	static boolean hasNoFraction(double num){
		int intTemp = (int) num;
		if(num == intTemp){
			return true;
		}
		return false;
	}


	static class Calculation{
		String operation;
		int operand;

		public Calculation(String s, int o){
			operation = s;
			operand = o;
		}

		public String getInfo(){
			return operation + " " + operand;
		}
	}

}