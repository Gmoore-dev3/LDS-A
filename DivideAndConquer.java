package assignment2;

public class DivideAndConquer {

    public static int fibonacci(int n) {
        // ----------- TASK 1.A.a --------------- //
        // if 0 or 1, use fibonnacci starting base cases
        if(n==0){return 0;}
        else if(n==1){return 1;}

        // otherwise, use the fibonnacci seqeunce algorithm
        else{return fibonacci(n-1) + fibonacci(n-2);}
    }

    public static int search(int[] A, int v){
        // ----------- TASK 1.A.b --------------- //
        int low = 0;
        int high = A.length-1;
        int mid = A.length/2;
        
        // optimisation calls for a possible quick return
        if(v == A[low]){return low;}
        if(v == A[high]){return high;}

        // while the value is not at the midpoint
        while(A[mid] != v){

            /* if the value is less than the midpoint,
             * set the new end point to the current midpoint
             * set the new midpoint
             */
            if(v < A[mid]){
                high = mid;
                mid/=2;
            }

            /* if the value is more than the midpoint,
             * set the new low point to the current midpoint
             * set the new midpoint (taking into account Java rounding)
             */
            else if(A[mid] < v){
                low = mid;
                if((high-mid % 2) == 1){mid--;}
                mid += ((high-mid)/2);
            }

            // If the value is more than the largest A value OR low ends up directly behind high, return -1 as the number is not in list
            if((A[high] < v) || (low == high-1)){return -1;}
        }
        return mid;
    }


    public static void hanoi(int n, char A, char B, char C) {
        // ----------- TASK 1.A.c --------------- //
        // if n = 1, move the disk from the first pole to the last pole
        if (n == 1) {System.out.println(A + " -> " + C);} 
        else {
            // Recursively move n-1 disks from A to B, using C as a buffer
            hanoi(n - 1, A, C, B);
            
            // Move the nth disk from A to C
            System.out.println(A + " -> " + C);
            
            // Recursively move the n-1 disks from B to C, using A as a buffer
            hanoi(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(fibonacci(i));
        }
        System.out.println();
        for (int i=0; i<10; i++) {
            System.out.println(search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, i));
        }
        System.out.println();
        hanoi(4, 'A', 'B', 'C');
    }
}