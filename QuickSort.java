package assignment2;

public class QuickSort {

    private static int partition(int[] A, int p, int r)
    {
        // TASK 2.B.a
        int pivot = A[r];
        int i = p - 1;

        for (int j = p; j <= r -1; j++) {
            if(A[j] < pivot){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        i++;
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;

        return i;
    }

    private static void quicksort(int[] A, int p, int r)
    {
        // TASK 2.B.b
        if(r <= p) return;
        int pivot = partition(A, p, r);
        quicksort(A, p, pivot-1);
        quicksort(A, pivot+1, r);
    }

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
