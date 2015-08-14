import java.util.*;
public class uva118MutantFlatworldExplorers {
	public static void main(String []  args){
		Scanner sc = new Scanner(System.in);
		int mapX = sc.nextInt(), mapY = sc.nextInt();
		Location [][] map = new Location[mapY+1][mapX+1];
		for(Location [] array : map){
			Arrays.fill(array, new Location());
		}
		while(sc.hasNextLine()){
			Robot r = new Robot(sc.nextInt(), sc.nextInt(), sc.nextLine().trim().charAt(0));
			char [] instructions = sc.nextLine().toCharArray();
			int tempX, tempY;
			boolean lost = false;
			for(char i : instructions){
				if(i == 'R'){
					r.turnRight();
				}
				else if(i == 'L'){
					r.turnLeft();
				}
				else{
					tempX = r.posX;
					tempY = r.posY;
					r.moveForward();
					//System.out.println("Temp X " + tempX + ", TempY " + tempY);
					if(r.posX > mapX || r.posX < 0 || r.posY < 0 || r.posY > mapY){
						if(!map[tempY][tempX].scent){
							System.out.println(tempX + " " + tempY + " " + r.direction + " LOST");
							map[tempY][tempX].scent = true;
							lost = true;
							break;
						}
						else{
							//rollback asnd ignore the command
							r.posX = tempX;
							r.posY = tempY;
						}
					}
				}
			}
			if(!lost){
				System.out.println(r.getInfo());
			}
		}
	}
}

class Robot{
	char direction;
	int posX, posY;
	public Robot(int x, int y, char dir){
		posX = x;
		posY = y;
		direction = dir;
	}
	public void turnRight(){
		if(direction == 'N'){direction = 'E';}
		else if(direction == 'E'){direction = 'S';}
		else if(direction == 'S'){direction = 'W';}
		else{direction = 'N';}
	}
	public void turnLeft(){
		if(direction == 'N'){direction = 'W';}
		else if(direction == 'W'){direction = 'S';}
		else if(direction == 'S'){direction = 'E';}
		else{direction = 'N';}
	}
	
	public void moveForward(){
		if(direction == 'N'){posY++;}
		else if(direction == 'E'){posX++;}
		else if(direction == 'S'){posY--;}
		else{posX--;}
	}
	public String getInfo(){
		return posX + " " + posY + " " + direction;
	}
}

class Location{
	boolean scent;
	public Location(){
		scent = false;
	}
}