import java.util.*;
public class uva11831StickerCollector {
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		while(true){
			
			int N = sc.nextInt(), M = sc.nextInt(), S = sc.nextInt(); sc.nextLine();
			if(N+M+S == 0){break;}
			
			char [][] map = new char [N][M];
			boolean robotFound = false;
			Robot robot = null;
			for(int i = 0; i < N; i++){
				map[i] = sc.nextLine().toCharArray();
				if(!robotFound){
					for(int j = 0; j < map[i].length; j++){
						
						char c = map[i][j];
						if(c == 'N' || c == 'S' || c == 'L' || c == 'O'){
							robot = new Robot(i, j, c); robotFound = true;
						}
					}
				}
			}
			char [] queries = sc.nextLine().toCharArray();
			//for each query
			for(int i = 0; i < S; i++){
				char query = queries[i];
				if(query == 'D'){
					robot.turnRight();
				}
				else if(query == 'E'){
					robot.turnLeft();					
				}
				else if(query == 'F'){
					int tempRow = robot.row, tempCol = robot.col;
					robot.moveForward();
					if(robot.row < 0 || robot.row > N-1 || robot.col > M-1 || robot.col < 0){
						robot.row = tempRow; robot.col = tempCol;
					}
					else{
						char currentChar = map[robot.row][robot.col];
						if(currentChar == '*'){
							robot.collectSticker();
							map[robot.row][robot.col] = '.';
						}
						else if(currentChar == '#'){
							robot.row = tempRow; robot.col = tempCol;
						}
					}
				}
			}
			System.out.println(robot.sticker);
		}
		
	}
	
	static class Robot{
		int row, col, sticker;
		char direction;
		public Robot(int r, int c, char d){
			row = r; col = c; direction = d; sticker = 0;
		}
		void moveForward(){
			if(direction == 'N'){
				row--;
			}
			else if(direction == 'S'){
				row++;
			}
			else if(direction == 'L'){
				col++;
			}
			else{
				col--;
			}
		}
		void collectSticker(){sticker++;}
		
		void printInfo(){
			System.out.println(row + " " + col + " " + direction);
		}
		void turnRight(){
			if(direction == 'N'){direction = 'L';}
			else if(direction == 'L'){ direction = 'S'; }
			else if(direction == 'S'){direction = 'O';}
			else{direction = 'N';}
		}
		
		void turnLeft(){
			if(direction == 'N'){direction = 'O';}
			else if(direction == 'O'){ direction = 'S'; }
			else if(direction == 'S'){direction = 'L';}
			else{direction = 'N';}
		}
	}
}
