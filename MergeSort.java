package assignment2;

public class MergeSort {

    private static int[] merge(int[] A1, int[] A2)
    {
        // TASK 2.A.a
        int[] A = new int[A1.length + A2.length];
        
        int i = 0 , j = 0;

        for (int k = 0; k < A.length; k++) {
            if(j < A2.length && i < A1.length){
                if (A1[i] <= A2[j]) {
                    A[k] = A1[i];
                    i++;
                } 
                else {
                    A[k] = A2[j];
                    j++;
                }
            }
            else{
                if(i < A1.length){
                    A[k] = A1[i];
                    i++;
                }
                if(j < A2.length){
                    A[k] = A2[j];
                    j++;
                }
            }
        }
        return A;
    }
    
    public static int[] mergesort(int[] A)
    {
        if(A.length <= 1){return A;}

        int half = A.length / 2;
        int[] Arr1 = new int[half];
        int[] Arr2 = new int[A.length - half];

        for (int i = 0; i < Arr2.length; i++) {
            if(i < half){Arr1[i] = A[i];}
            Arr2[i] = A[i+half];
        }

        int[] Arr1Sorted = mergesort(Arr1);
        int[] Arr2Sorted = mergesort(Arr2);
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