import java.util.*;

public class JJelly{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);

		int numStudent = sc.nextInt();

		Student [] students = new Student [numStudent];

		for(int i = 0; i < numStudent; i++){
			students[i] = new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(students);

		Student first = students[0];
		Student last = students[students.length-1];

		if(first.getVolume() == last.getVolume()){
			System.out.println("No child has lost jelly.");
		}
		else{
			System.out.println(first.name + " has lost jelly to " + last.name +".");
		}
	}

	static class Student implements Comparable <Student>{

		String name;
		int length, width, height;

		public Student(String n, int l, int w, int h){
			name = n;
			length = l;
			width = w;
			height = h;
		}

		public int getVolume(){
			return length * width * height;
		}

		public int compareTo(Student other){
			return this.getVolume() - other.getVolume();
		}
	}
}