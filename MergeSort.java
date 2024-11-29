package assignment2;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2){
        // ----------- TASK 2.A.a --------------- //
        // create the new Array with enough indexes for A1 and A2 elements
        int[] A = new int[A1.length + A2.length];
        // initialise the index trackers for A1 and A2
        int i = 0 , j = 0;

        // for every position in A
        for (int k = 0; k < A.length; k++) {
            // if A1 and A2 have both not been completely parsed
            if(j < A2.length && i < A1.length){
                /* find the smaller element between both array trackers
                 * add that element to the current position in A
                 * increase the tracker for whichever array was used
                 */
                if (A1[i] <= A2[j]) {
                    A[k] = A1[i];
                    i++;
                } 
                else {
                    A[k] = A2[j];
                    j++;
                }
            }
            // otherwise, fill the remaining spaces of A with the elements of the remaining array
            else{
                if(i < A1.length){
                    A[k] = A1[i];
                    i++;
                }
                else{
                    A[k] = A2[j];
                    j++;
                }
            }
        }
        return A;
    }
    
    public static int[] mergesort(int[] A){
        // ----------- TASK 2.A.b --------------- //
        // if one element exists in the array, automatically return the array
        if(A.length <= 1){return A;}

        // created 2 arrays with enough indexs to fit all of A
        int half = A.length/2;
        int[] Arr1 = new int[half];
        int[] Arr2 = new int[A.length-half];

        // populate the half arrays with the elements of the original array (taking into account rounding of an odd sized array)
        for (int i = 0; i < Arr2.length; i++) {
            if(i < half){Arr1[i] = A[i];}
            Arr2[i] = A[i+half];
        }
        // divide and conquer by halving and merging arrays using recursion
        int[] Arr1Sorted = mergesort(Arr1);
        int[] Arr2Sorted = mergesort(Arr2);

        // After the recursive calls, merge the final two arrays to return one sorted array
        int[] B = merge(Arr1Sorted, Arr2Sorted);
        return B;
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
        print(merge(new int[] {1,3,5,7,9}, new int[] {2,4,6,8}));
        print(mergesort(new int[] {5,2,8,1,3,9,7,4,6} ));
    }

}