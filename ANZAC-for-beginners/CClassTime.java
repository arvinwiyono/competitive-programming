import java.util.*;

public class CClassTime{
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);
		int numStudent = sc.nextInt();

		Student [] students = new Student [numStudent];

		for(int i = 0; i < numStudent; i++){
			students[i] = new Student(sc.next(), sc.next());
		}

		Arrays.sort(students);

		for(Student s : students){
			System.out.println(s.firstName + " " + s.lastName);
		}


	}


	static class Student implements Comparable<Student>{
		String firstName, lastName;

		public Student(String first, String last){
			firstName = first;
			lastName = last;
		}

		public int compareTo(Student other){
			if(this.lastName.equals(other.lastName)){
				return this.firstName.compareTo(other.firstName);
			}
			else{
				return this.lastName.compareTo(other.lastName);
			}
		}

	}
}