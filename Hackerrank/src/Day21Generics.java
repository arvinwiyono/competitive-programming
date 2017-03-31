/**
 * Created by Arvin on 31-Mar-17.
 */
public class Day21Generics {
    public static void main(String [] args){
        System.out.println("Testing my generic class");
        Printer<String> p = new Printer<String>();
        String [] a = {"This", "Is", "Arvin"};
        p.printArray(a);
    }

    static class Printer<T>{
        void printArray(T [] a){
            for(T element : a){
                System.out.println(element.toString());
            }
        }
    }
}
