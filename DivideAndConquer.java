package assignment2;

public class DivideAndConquer {

    public static int fibonacci(int n) {
        // TASK 1.A.a
        if(n==0){return 0;}
        else if(n==1){return 1;}
        else{return fibonacci(n-1) + fibonacci(n-2);}
    }

    public static int search(int[] A, int v)
    {
        // TASK 1.A.b
        int low = 0;
        int high = A.length - 1;
        int mid = A.length/2;


        int counter = 0;
    
        if(v == A[low]){return low;}
        if(v == A[high]){return high;}

        while(A[mid] != v){
            if(v < A[mid]){
                high = mid;
                mid/=2;
            }
            else if(A[mid] < v){
                low = mid;
                int diff = (high-low);
                if((diff % 2) == 1){diff--;}
                mid = (diff/2)+low;
            }
            if((A[high] < v) || (low == high-1)){return -1;}
            counter++;
        }
        System.out.println("Counter ran " + counter + " times");
        return mid;
    }


    public static void hanoi(int n, char A, char B, char C) {
        if (n == 1) {System.out.println(A + " -> " + C);} 
        else {
            // Move n-1 disks from A to B, using C as a buffer
            hanoi(n - 1, A, C, B);
            
            // Move the nth disk from A to C
            System.out.println(A + " -> " + C);
            
            // Move the n-1 disks from B to C, using A as a buffer
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
        hanoi(3, 'A', 'B', 'C');
    }
}