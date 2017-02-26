import java.util.*;
class BinarySearch{
    // Worst-case complexity: O(log2(n))
    // Precondition: Input must be sorted in ascending order
    public static void main(String [] args){
        int [] numbers = {23, 3653, 79, 52, 77, 5, 93, 22, 305, 201, 1, 0, 99, 59, 71};
        Arrays.sort(numbers);
        System.out.println("Numbers: " + Arrays.toString(numbers));
        System.out.println(binarySearch(numbers, 201, 0, numbers.length));
        System.out.println(binarySearch(numbers, 32, 0, numbers.length));
        System.out.println(binarySearch(numbers, 0, 0, numbers.length));
        System.out.println(binarySearch(numbers, 79, 0, numbers.length));
        System.out.println(binarySearch(numbers, 3653, 0, numbers.length));

        // With looping function
        System.out.println("---WITH LOOP---");
        System.out.println(binarySearchLoop(numbers, 201));
        System.out.println(binarySearchLoop(numbers, 32));
        System.out.println(binarySearchLoop(numbers, 0));
        System.out.println(binarySearchLoop(numbers, 79));
        System.out.println(binarySearchLoop(numbers, 3653));
    }

    private static int binarySearch(int [] intArray, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        int theNumber = intArray[mid];
        if(theNumber == target){
            return mid;
        }
        else if(theNumber > target){
            // Search the left hand side
            return binarySearch(intArray, target, start, mid-1);
        }
        else{
            // Search the right hand side
            return binarySearch(intArray, target, mid+1, end);
        }
    }

    private static int binarySearchLoop(int [] intArray, int target){
        int mid = 0; // Jut for initialization
        int start = 0;
        int end = intArray.length;
        while(start <= end){
            mid = (start + end) / 2;
            int theNumber = intArray[mid];
            if(theNumber == target){
                return mid;
            }
            else if(theNumber < target){
                // Serach the right hand side
                start = mid + 1;
            }
            else{
                // Search the left hand side
                end = mid - 1;
            }
        }
        return -1;
    }
}
