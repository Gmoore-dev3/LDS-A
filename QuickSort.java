package assignment2;

public class QuickSort {

    private static int partition(int[] A, int p, int r){
        // ----------- TASK 2.B.a --------------- //

        // Select the pivot as the last element of the partition
        int pivot = A[r];

        // Initialize the i index tracker before the first element of the partition
        int i = p-1;

        // For each element in the partition
        for (int j = p; j <= r-1; j++) {
            // If the element at tracker j is less than the pivot
            if(A[j] < pivot){
                // Increment the index of the i tracker and swap the values at i and j
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // After the loop, all elements less than the pivot are to the left of (i + 1),
        // Now we need to place the pivot in its correct position.
        i++;

        // Swap the pivot with the element at the i index
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;

        // Return the final index of the pivot, which is now at the correct sorted position
        return i;
    }

    private static void quicksort(int[] A, int p, int r){
        // ----------- TASK 2.B.b --------------- //
        if(r <= p) return;              // base case because we cannot split the array any further
        int pivot = partition(A, p, r); // find the pivot
        quicksort(A, p, pivot-1);       // recursively call on the left array
        quicksort(A, pivot+1, r);       // recursively call on the right array
    }

    //----------------------------------------------------------//
    public static void quicksort(int[] A)
    {
        quicksort(A, 0, A.length-1);
    }

    private static void print(int[] A)
    {
        for (int i=0; i<A.length; i++)
        {
            System.out.print(A[i] + ((i<A.length-1)?", ":""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[] {5,2,8,1,3,9,7,4,6};
        quicksort(A);
        print(A);
    }

}
