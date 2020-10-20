// Java code for n largest elements in an array
import java.util.Arrays;

// Find the nth largest number in an array, by its value. n > 0. All positive numbers.
public class main {

    // Function to return nth element in a given array
    public static int firstLargest(int[] arr, int n)
    {
        // Sort the given array
        Arrays.sort(arr);

        // Return 1st highest element in the sorted array
        return arr[n + 3];
    }
    public static int secondLargest(int[] arr, int n2)
    {
        // Sort the given array
        Arrays.sort(arr);

        // Return 2nd highest element in the sorted array
        return arr[n2 + 1];
    }
    /*
    public static int thirdLargest(int[] arr, int n3)
    {
        // Sort the given array
        Arrays.sort(arr);

        // Return kth element in the sorted array
        return arr[n3 - 6];
    }*/
    // Driver program
    public static void main(String[] args) {
        {
            int[] arr = new int[] { 1, 2, 3, 3, 4, 4};
            int n = 1;
            int n2 = 2;
            //int n3 = 5;
            System.out.println("1st largest element is " + firstLargest(arr, n));
            System.out.println("2nd largest element is " + secondLargest(arr, n2));
            //System.out.println("3rd largest element is " + thirdLargest(arr, n3)); //out-of-bounds if returning -1
        }
    }
}
