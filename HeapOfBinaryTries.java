package assignment2;

public class HeapOfBinaryTries {
    private BinaryTrie[] A;
    private int heapsize;

    /*
     * left = 2i
     * right = 2i + 1
     * parent = i / 2
     */

    private void heapify(int i) {
        // ----------- TASK 3.A.a --------------- //
        int leftChild, rightChild, current;
            while (true) {
                // get the indexes of the decendants
                int start = (2 * i)+1;
                leftChild = start;
                rightChild = start + 1;
                current = i;

                // If either decendant is smaller than current, swap current value
                if (leftChild < heapsize && A[leftChild].compare(A[i])) {
                    current = leftChild;
                }

                if (rightChild < heapsize && A[rightChild].compare(A[current])) {
                    current = rightChild;
                }

                // current has changed, the heap has been violated and must be repaired
                if(current != i){
                    // Swap A[i] with A[current]
                    BinaryTrie temp = A[i];
                    A[i] = A[current];
                    A[current] = temp;

                    // repeat the prodecure for the exchanged decendants
                    i = current;
                }
                else{break;}
            }
    }


    public HeapOfBinaryTries(BinaryTrie[] A) {
        // ----------- TASK 3.A.b --------------- //
        this.A = A;
        this.heapsize = A.length;
        // Heapify from the bottom to ensure that the heap is maintained correctly
        for (int i = (heapsize / 2)-1; i >= 0; i--) {
            heapify(i);   
        }
    }

    public BinaryTrie extractMin()
    {
        // ----------- TASK 3.A.c --------------- //
        // if the heap is empty, throw an exception
        if (heapsize == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        
        // Copy the root value to min
        BinaryTrie min = A[0];
        // Copy the last element to the root position
        A[0] = A[heapsize - 1];
        // Reduce the heapsize by one to remove the duplicated element
        heapsize--;
        // Heapify at the root to maintain heap property
        heapify(0);
        return min;
    }

    public void insert(BinaryTrie x) {
        // Increment the size of the heap
        heapsize++;
        // Ensure there is enough space for the new element
        if (heapsize >= A.length) {
            // Expand the array if needed
            BinaryTrie[] newArray = new BinaryTrie[A.length * 2];
            System.arraycopy(A, 0, newArray, 0, A.length);
            A = newArray;
        }
        
        // Bubble up to maintain the heap property
        // Start from the last index
        int i = heapsize - 1;

        // While there are nodes left to be checked and the current node is less than the parent
        while (i > 0 && x.compare(A[(i - 1) / 2])) { 
            // The current node is replaced with the value of the parent node
            A[i] = A[(i - 1) / 2];
            // Move the index to reflect the new parent index
            i = (i - 1) / 2; 
        }
        // Place the new element at the end of the heap
        A[i] = x;
    }

    public int size()
    {
        return heapsize;
    }
}
