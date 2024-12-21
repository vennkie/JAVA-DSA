import java.util.Scanner;

public class Linearsearch { // The class name matches the file name

    // Method to perform linear search
    static int search(int[] arr, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i; // Return the index when the element is found
        }
        return -1; // Return -1 if the element is not found
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Initialize the array
        int[] arr = new int[n];

        // Input the array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input the element to search for
        System.out.print("Enter the number to search: ");
        int x = sc.nextInt();

        // Perform the search
        int index = Linearsearch.search(arr, n, x);

        // Display the result
        if (index == -1)
            System.out.println("Element is not present in the array.");
        else
            System.out.println("Element found at position " + (index + 1)); // Adjusting for 1-based index

        sc.close(); // Close the Scanner
    }
}
